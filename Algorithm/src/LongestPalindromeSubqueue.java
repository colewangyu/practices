/**
 * Created by wy on 2016-05-26.
 * 最长回文子序列相关问题
 * 1. 最长回文子序列长度
 * 2. 最长回文子序列
 * 3. 最长回文子序列要删除的字符数
 */
public class LongestPalindromeSubqueue {
    /**
     * 获取最长回文子序列长度
     *
     * @param s 待计算的字符串
     * @return 该字符串的最长回文子序列长度
     */
    public int getLengthofLPS(String s) {
        //输入数据验证
        if (s == null)
            throw new NullPointerException();
        return computeLengthofLPS(s.toCharArray(), 0, s.length() - 1);
    }

    /**
     * 获取最长回文子序列
     *
     * @param s 待计算的字符串
     * @return 该字符串的最长回文子序列
     */
    public String getLPS(String s) {
        //输入数据验证
        if (s == null)
            throw new NullPointerException();

        String[] str;
        int len;
        len = s.length();
        str = new String[len];
        for(int i = 0 ; i < len; i++) {
            str[i] = String.valueOf(s.charAt(i));
        }
        return computeLPS(str, 0, s.length() - 1);
    }

    /**
     * 获取最长字符子序列需要删除的字符
     *
     * @param s 待计算的字符串
     * @return 获取最长回文子序列需要删除的字符数
     */
    public int getDeleteLPS(String s) {
        //输入数据验证
        if (s == null)
            throw new NullPointerException();

        //计算最长回文子序列
        String LPS;
        String[] str;

        str = new String[s.length()];
        for(int i = 0 ; i <  s.length(); i++) {
            str[i] = String.valueOf(s.charAt(i));
        }
        LPS = computeLPS(str, 0, s.length() - 1);

        //获取删除的字符串长度
        int count = 0;
        int j;
        int i;
        for(j = 0,i = 0; i < s.length() && j < LPS.length(); i++) {
            if(s.charAt(i) != LPS.charAt(j)) {
                count++;
            } else {
                j++;
            }
        }
        count += s.length() - i;
        return count;
    }

    /**
     * 递归计算最长回文子序列的长度
     *
     * @param dp
     * @param start
     * @param end
     * @return
     */
    private int computeLengthofLPS(char[] dp, int start, int end) {
        int len;
        if (start == end) {
            len = 1;
        } else if (start > end) {
            len = 0;
        } else {
            if (dp[start] != dp[end]) {
                len = Math.max(computeLengthofLPS(dp, start + 1, end), computeLengthofLPS(dp, start, end - 1));
            } else {
                len = computeLengthofLPS(dp, start + 1, end - 1) + 2;
            }
        }
        return len;
    }

    /**
     * 递归计算最长回文子序列（LongestPalindromeSubqueue）
     *
     * @param dp
     * @param start
     * @param end
     * @return
     */
    private String computeLPS(String[] dp, int start, int end) {
        if (start == end) {
            return dp[start];
        } else if (start > end) {
            return "";
        } else {
            if (!dp[start].equals(dp[end])) {
                return computeLPS(dp, start + 1, end).length() > computeLPS(dp, start, end - 1).length() ? computeLPS(dp, start + 1, end) : computeLPS(dp, start, end - 1);
            } else {
                return dp[start] + computeLPS(dp, start + 1, end - 1) + dp[end];
            }
        }
    }
}
