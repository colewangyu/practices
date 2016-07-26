package Level_2;

import java.util.Scanner;

/**
 * Created by wy on 2016-04-19.
 */
public class _1032_LongestPalindromicSubString {
    public static void main(String[] args) {
        int totleLine;
        String tempStr;
        Scanner in = new Scanner(System.in);
        totleLine = new Integer(in.nextLine());
        while(totleLine-- > 0) {
            tempStr = in.nextLine();
            System.out.println(getLengthOfLongestPalindromicSubString(tempStr));
        }
    }

    public static int getLengthOfLongestPalindromicSubString(String s) {
        char[] str = s.toCharArray();
        int maxLen;
        int strLen;
        int j;
        int leftIndex;
        int rightIndex;

        maxLen = 0;
        strLen = str.length;
        //遍历str
        for(int i = 0; i < strLen; i++) {
            //计算奇数回文长度
            j = 0;
            leftIndex = i - j;
            rightIndex = i + j;
            while (leftIndex >= 0 && rightIndex < strLen) {
                if (str[leftIndex] != str[rightIndex]) {
                    break;
                } else {
                    if ((2 * j + 1) > maxLen) {
                        maxLen = 2 * j + 1;
                    }
                    j++;
                    leftIndex = i - j;
                    rightIndex = i + j;
                }
            }
            //计算偶数回文长度
            j = 0;
            leftIndex = i;
            rightIndex = i + 1;
            while (leftIndex >= 0 && rightIndex < strLen) {
                if (str[leftIndex] != str[rightIndex]) {
                    break;
                } else {
                    if ((2 * j) > maxLen) {
                        maxLen = 2 * j;
                    }
                    j++;
                    leftIndex = i - j + 1;
                    rightIndex = i + j;
                }
            }
        }
        return maxLen;
    }
}
