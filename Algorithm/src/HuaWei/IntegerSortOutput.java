package HuaWei;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by wy on 2016-09-10.
 * 对输入值进行从小到大排序，依次输出，连续的只输出首尾。
 * 样例输入: 1,4,3,110,2,90,7
 * 样例输出: 1 4 7 90 110
 */
public class IntegerSortOutput {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> arr = new ArrayList<Integer>();
        String[] strs = in.nextLine().split(",");
        int[] ints = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            ints[i] = Integer.valueOf(strs[i]);
        }

        Arrays.sort(ints);

        int tmp = ints[0];
        boolean flag =false;
        System.out.print(tmp+" ");
        for (int i = 1; i < ints.length; i++) {
            if (ints[i] == tmp + 1 || ints[i] == tmp) {
                flag = true;
                tmp = ints[i];
                continue;
            } else {
                if(flag) {
                    System.out.print(tmp+" ");
                    flag = false;
                }
                tmp = ints[i];
                System.out.print(tmp+" ");
            }
        }
        if(flag)
            System.out.print(tmp+" ");
    }
}
