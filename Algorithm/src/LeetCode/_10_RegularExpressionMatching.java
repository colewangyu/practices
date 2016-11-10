package LeetCode;

/**
 * Created by wy on 2016-11-09.
 */
public class _10_RegularExpressionMatching {
    /**
     * '.' Matches any single character.
     * '*' Matches zero or more of the preceding element.
     * <p>
     * The matching should cover the entire input string (not partial).
     * <p>
     * The function prototype should be:
     * bool isMatch(const char *s, const char *p)
     * <p>
     * Some examples:
     * isMatch("aa","a") → false
     * isMatch("aa","aa") → true
     * isMatch("aaa","aa") → false
     * isMatch("aa", "a*") → true
     * isMatch("aa", ".*") → true
     * isMatch("ab", ".*") → true
     * isMatch("aab", "c*a*b") → true
     *
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        char[] sChr = s.toCharArray();
        char[] pChr = p.toCharArray();
        int indexS = 0;
        int indexP = 0;

        while (indexP < pChr.length) {
            if(indexP + 1 < pChr.length && pChr[indexP + 1] == '*') {
                indexP++;
                continue;
            }

            // 普通字符、“.”、“*”分别进行处理
            if (pChr[indexP] == '*') {
                // “*”
                char prev = pChr[indexP - 1];
                // 逐一验证*重复0次、1次、...、n次（不超过sChr的长度）
                int repeatTimes = 0;
                while (indexS + repeatTimes <= sChr.length) {
                    // 进行匹配
                    for (int i = 0; i < repeatTimes; i++) {
                        if (prev == '.' || prev == sChr[indexS + i]) {
                            continue;
                        } else {
                            return false;
                        }
                    }
                    // 剩余的进行递归
                    if (indexS + repeatTimes >= sChr.length && indexP >= pChr.length - 1) {
                        // 数据已经匹配完
                        return true;
                    }
                    if (indexS + repeatTimes <= sChr.length && isMatch(s.substring(indexS + repeatTimes, s.length()), p.substring(indexP + 1, p.length()))) {
                        return true;
                    } else {
                        repeatTimes++;
                        continue;
                    }
                }
                return false;
            } else if (pChr[indexP] == '.') {
                // “.”
                indexP++;
                indexS++;
                continue;
            } else {
                // 普通字符
                if (indexS < sChr.length && pChr[indexP++] == sChr[indexS++])
                    continue;
                else
                    return false;
            }
        }

        if(indexS == sChr.length) {
            return true;
        } else {
            return false;
        }
    }
}
