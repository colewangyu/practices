import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by wy on 2016-09-12.
 */
public class RandomArrayWithoutRepeat {
    /**
     * 打印数组中不重复的数字
     *
     * @param n 数组
     * @param m 不重复数字的数量
     * @return 输出含有指定个不重复数字的数组
     */
    public int[] printNoRepeat(int[] n, int m) {
        int[] result;
        HashMap<Integer, Integer> map;

        map = new HashMap<Integer, Integer>();
        for (int i = 0; i < n.length; i++) {
            map.put(n[i], 0);
            if (map.size() == m) {
                break;
            }
        }

        if(m > map.size())
            throw new IllegalArgumentException("m = " + m + " > " + map.size());

        Iterator<Integer> it = map.keySet().iterator();
        result = new int[map.size()];
        int index = 0;
        while(it.hasNext() && index < map.size()) {
            result[index] = it.next();
            index++;
        }

        return result;
    }
}
