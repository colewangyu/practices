package HuaWei;

import java.util.Scanner;

/**
 * Created by cole on 2016-08-16.
 *
 * 二叉树某一支分支的和等于某一值,输出分支.
 * 输入案列:
 * 7
 * 1,2,3,4
 * 输出:
 * 1,2,4
 */
public class BinarySum {
    static int[] BTArr;
    static boolean flag = false;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int sum = new Integer(in.nextLine());
        String str = in.nextLine();
        String[] strs = str.split(",");
        BTArr = new int[strs.length + 1];
        for(int i = 0; i < strs.length; i++) {
            BTArr[i + 1] = new Integer(strs[i]);
        }

        find(1, sum, new StringBuffer());
        if(flag == false) {
            System.out.println("error");
        }
    }

    /**
     *
     * @param index 结点下标
     * @param totle 路径和
     * @param sb 输出内容
     */
    static void find(int index, int totle, StringBuffer sb) {
        StringBuffer sbtemp = new StringBuffer(sb);
        totle -= BTArr[index];
        sbtemp.append(BTArr[index]).append(",");
       if(totle == 0) {
           flag = true;
            System.out.println(sbtemp.substring(0,sbtemp.length() - 1));
            return;
        }
        if(totle < 0)
            return;
        if(index * 2 < BTArr.length) {
            find(index * 2, totle, sbtemp);
            find(index * 2 + 1, totle, sbtemp);
        }
    }
}
