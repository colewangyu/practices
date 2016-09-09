package HuaWei;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by wy on 2016-09-09.
 * 输出一个字符串的全排列
 */
public class FullArray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int count = in.nextInt();
        for (int i = 0; i <= s.length() - count; i++)
            print(s, i, count, new StringBuffer());
    }

    private static void print(String s, int startIndex, int count, StringBuffer sb) {
        StringBuffer sbTmp = new StringBuffer(sb);
        // 满足条件时连续输出
        if (startIndex >= (s.length() - count)) {
            while (startIndex < s.length()) {
                sbTmp.append(s.charAt(startIndex++));
            }
            System.out.println(sbTmp.toString());
            return;
        }
        // 递归输出
        for (int i = startIndex; i < (s.length() - count); i++) {
            sb.append(s.charAt(i));
            if (--count > 0) {
                print(s, i + 1, count, sbTmp);
            } else {
                System.out.println(sbTmp.toString());
                return;
            }
        }
    }
}
