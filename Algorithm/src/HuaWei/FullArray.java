package HuaWei;

import java.util.Scanner;

/**
 * Created by wy on 2016-09-09.
 * 指定长度的全排列
 * input: abc 2
 * output: ab ab bc
 */
public class FullArray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int count = in.nextInt();
        if(count > s.length()) {
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            StringBuffer sb = new StringBuffer(String.valueOf(s.charAt(i)));
            printRecursion(s, i + 1, count - 1, sb);
        }
    }

    private static void printRecursion(String s, int index, int count, StringBuffer sb) {
        if (count == 0)
            System.out.print(sb.toString() + " ");
        for (int i = index; i < s.length() && count > 0; i++) {
            StringBuffer sbTmp = new StringBuffer(sb);
            sbTmp.append(s.charAt(i));
            printRecursion(s, i + 1, count - 1, sbTmp);
        }
    }
}
