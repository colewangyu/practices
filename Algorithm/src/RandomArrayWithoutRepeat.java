import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by wy on 2016-09-12.
 */
public class RandomArrayWithoutRepeat {
    public static void main(String[] args) {
        int[] r = printNoRepeat(new int[]{2, 4, 5, 5}, 3);
        for (int i : r) {
            System.out.print(i + " ");
        }
    }

    public static int[] printNoRepeat(int[] n, int m) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        ArrayList<Integer> arrIndex = new ArrayList<Integer>();
        int[] result = new int[m];
        for (int i = 0; i < n.length; i++) {
            map.put(n[i], 0);
        }
        Iterator<Integer> it = map.keySet().iterator();
        while(it.hasNext()) {
            int i = it.next();
            arrIndex.add(i);
        }

        for (int i = 0; i < m; i++) {
            int tmp = (int) (Math.random() * arrIndex.size());
            result[i] = arrIndex.get(tmp);
            arrIndex.remove(tmp);
        }
        return result;
    }
}
