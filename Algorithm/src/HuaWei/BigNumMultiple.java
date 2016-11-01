package HuaWei;

import java.util.Scanner;

/**
 * Created by wy on 2016-09-09.
 * 大数相乘
 */
public class BigNumMultiple {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = in.next();
        String s2 = in.next();
        in.close();
        byte[] num1 = new byte[s1.length()];
        byte[] num2 = new byte[s2.length()];
        byte[] result = new byte[num1.length + num2.length];
        for (int i = num1.length - 1, j = 0; i >= 0; i--, j++) {
            num1[j] = (byte) Integer.parseInt(String.valueOf(s1.charAt(i)));
        }
        for (int i = num2.length - 1, j = 0; i >= 0; i--, j++) {
            num2[j] = (byte) Integer.parseInt(String.valueOf(s2.charAt(i)));
        }
        for (int i = num1.length - 1; i >= 0; i--) {
            for (int j = num2.length - 1; j >= 0; j--) {
                result[i + j] = (byte) (num1[i] * num2[j] + result[i + j]);
            }
        }

        for (int i = 0; i < result.length - 1; i++) {
            result[i + 1] += result[i] / 10;
            result[i] = (byte) (result[i] % 10);
        }

        boolean flag = false;
        for (int i = result.length - 2; i > 0; i--) {
            if (result[i] != 0) {
                flag = true;
            }
            if (flag)
                System.out.print(result[i]);
        }
        System.out.println(result[0]);
    }
}
