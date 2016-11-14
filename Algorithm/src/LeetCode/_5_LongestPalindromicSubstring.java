package LeetCode;

/**
 * Created by wy on 2016-11-14.
 */
public class _5_LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        char[] str = s.toCharArray();
        int maxLen;
        int maxCenter;
        int strLen;
        int j;
        int leftIndex;
        int rightIndex;

        maxLen = 0;
        maxCenter = 0;
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
                        maxCenter = i;
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
                        maxCenter = i;
                    }
                    j++;
                    leftIndex = i - j + 1;
                    rightIndex = i + j;
                }
            }
        }
        if(maxLen % 2 == 0) {
            return s.substring(maxCenter + 1 - maxLen/2, maxCenter + maxLen/2 + 1);
        } else {
            return s.substring(maxCenter - maxLen/2, maxCenter + maxLen/2 + 1);
        }
    }
}
