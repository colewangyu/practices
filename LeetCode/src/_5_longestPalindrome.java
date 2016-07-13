/**
 * Created by cole on 2016-05-15 Sunday.
 */
public class _5_longestPalindrome {
    public String longestPalindrome2(String s) {
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
        for (int i = 0; i < strLen; i++) {
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
        if (maxLen % 2 == 0) {
            return s.substring(maxCenter + 1 - maxLen / 2, maxCenter + maxLen / 2 + 1);
        } else {
            return s.substring(maxCenter - maxLen / 2, maxCenter + maxLen / 2 + 1);
        }
    }


    /**
     * Manacher算法
     * [时间复杂度]:O(n)
     *
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        char[] T = preProcess(s).toCharArray();
        int n = T.length;
        int[] P = new int[n];
        int id = 0, maxId = 0;
        //遍历首尾以外的字符(首尾是标志符)
        for (int i = 1; i < n - 1; i++) {
            //【Manacher算法核心】不对已经判断过的回文字串进行判断
            //【前提】i在maxId内
            //1.如果i针对id的对称点j(j=2*id-1),j的半径的下限已经超出了当前最长回文子串的下限,则设置p[i]=maxId-i,即半径到maxId为止(在i处已不可能出现最长回文子串，其最终半径为maxId-1)
            //2.如果j的半径未超出当前最长回文子串的下限,则设置p[i]=p[j],即半径与j相同，未超出maxId(在i处已不可能出现最长回文子串，其最终半径与p[j]相同)
            //3.如果j的半径与最长回文字串的下限重叠，则设置p[i]=p[j]=maxId-i(在i处可能出现最长回文字串)
            if (i < maxId) {
                P[i] = Math.min(maxId - i, P[2 * id - i]);
            } else {
                P[i] = 0;
            }
            //计算当前位置回文子串的延伸距离
            while (T[i + 1 + P[i]] == T[i - 1 - P[i]])
                P[i]++;
            //更新最长子串,记录其最右端和中心的下标
            if (i + P[i] > maxId) {
                id = i;
                maxId = i + P[i];
            }
        }
        //半径
        int maxLen = 0;
        //中心下标
        int centerIndex = 0;
        for (int i = 1; i < n - 1; i++) {
            if (P[i] > maxLen) {
                maxLen = P[i];
                centerIndex = i;
            }
        }
        int beginIndex = (centerIndex - 1 - maxLen) / 2;
        return s.substring(beginIndex, beginIndex + maxLen);
    }

    private static String preProcess(String s) {
        int n = s.length();
        if (n == 0) return "^$";
        //第一个字符设置特殊标志,这样可以减少回文子串扩展时的判断
        StringBuffer result = new StringBuffer("^");
        //所有字符之间和字符串首尾插入标志,使所有回文子串长度变为奇数
        for (int i = 0; i < n; i++) {
            result.append("#").append(s.charAt(i));
        }
        //末尾设置特殊标志,这样可以减少回文子串扩展时的判断
        result.append("#$");
        return result.toString();
    }
}
