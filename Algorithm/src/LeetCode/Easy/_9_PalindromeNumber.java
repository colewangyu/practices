package LeetCode.Easy;

/**
 * Created by wy on 2016-11-14.
 * Determine whether an integer is a palindrome. Do this without extra space.
 */
public class _9_PalindromeNumber {
    public boolean isPalindrome(int x) {
        char[] s = new Integer(x).toString().toCharArray();
        int halfLen = s.length / 2;
        boolean isPalindrome = true;

        if(s.length % 2 == 0) {
            //偶数
            for(int i = 0; halfLen - 1 - i >= 0; i++) {
                if(s[halfLen - 1 - i] != s[halfLen + i]) {
                    isPalindrome = false;
                    break;
                }
            }
        } else {
            //奇数
            for(int i = 0; halfLen - i >= 0; i++) {
                if(s[halfLen - i] != s[halfLen + i]) {
                    isPalindrome = false;
                    break;
                }
            }
        }
        return isPalindrome;
    }
}
