package NetEase;

import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by cole on 2016-09-23.
 * 输入一个字符串,获取到字符串中平方串(子串连续出现两次)的个数(重复的记为一次)
 */
public class SquareString {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String S = in.nextLine();
        char[] chars = S.toCharArray();
        int len = chars.length;
        HashSet<String> result = new HashSet<String>();
        for (int left = 0; left < len - 1; left++) {
            int right = left;
            int leftTmp = right + 1;
            for (; leftTmp + right - left < len; ) {
                if (isEquals(chars, left, right))
                    result.add(new String(chars, left, right - left + 1));
                right++;
                leftTmp++;
            }

        }
        System.out.println(result.size());
    }

    private static boolean isEquals(char[] chars, int left, int right) {
        int leftTmp = right + 1;
        int rightTmp = leftTmp + right - left;
        for (; leftTmp <= rightTmp; leftTmp++, left++) {
            if (chars[left] != chars[leftTmp])
                return false;
        }
        return true;
    }
}
