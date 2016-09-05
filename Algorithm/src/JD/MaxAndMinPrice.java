package JD;

import java.util.*;

/**
 * Created by cole on 2016-09-05.
 */
public class MaxAndMinPrice {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            // 标签数量
            int n = in.nextInt();
            // 购物数量
            int m = in.nextInt();
            if(n == 0 || m == 0){
                System.out.println(0 + " " + 0);
            }
            in.nextLine();
            // 价签
            int[] price = new int[n];
            String[] priceTmp = in.nextLine().split(" ");
            for (int i = 0; i < priceTmp.length; i++) {
                price[i] = new Integer(priceTmp[i]);
            }
            Arrays.sort(price);
            // 购物清单
            String tmp;
            Map<String, Integer> goods = new HashMap<String, Integer>();
            for (int i = 0; i < m; i++) {
                tmp = in.nextLine();
                if (goods.containsKey(tmp)) {
                    goods.put(tmp, goods.get(tmp) + 1);
                } else {
                    goods.put(tmp, 1);
                }
            }
            goods = sortByValue(goods);
            Set<String> key = goods.keySet();
            Iterator it = key.iterator();
            int max = 0;
            int min = 0;
            for(int i = n - 1, j = 0;it.hasNext(); i--,j++) {
                String goodsTmp = (String) it.next();
                max += goods.get(goodsTmp) * price[i];
                min += goods.get(goodsTmp) * price[j];
            }

            System.out.println(min + " " + max);

        }
    }

    public static Map sortByValue(Map m) {
        List l = new LinkedList(m.entrySet());
        Collections.sort(l, new Comparator() {
            // from smaller to greater
            public int compare(Object o1, Object o2) {
                return ((Comparable) ((Map.Entry) (o2)).getValue()).compareTo(((Map.Entry) (o1)).getValue());
            }
        });
        Map result = new LinkedHashMap();
        for (Iterator it = l.iterator(); it.hasNext(); ) {
            Map.Entry entry = (Map.Entry) it.next();
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }
}
