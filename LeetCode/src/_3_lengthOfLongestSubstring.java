import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 最长不重复子串
 * Created by cole on 2016-05-10 Tuesday.
 */
public class _3_lengthOfLongestSubstring {
    /**
     * 采用滑动窗口的办法,一个i作为左边界,j作为右边界
     * [时间复杂度]O(2n),最坏情况,每个字符会被扫描两次
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring2(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<Character>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    /**
     * lengthOfLongestSubstring2的改进方法,直接跳到重复的字符处
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int maxLen;
        char tmp;
        HashMap<Character, Integer> m;

        m = new HashMap<Character, Integer>();
        maxLen = 0;

        for (int j = 0, i = 0; j < s.length(); ) {
            tmp = s.charAt(j);
            if (!m.containsKey(tmp) || m.get(tmp) < i) {
                m.put(tmp, j++);
                maxLen = Math.max(j - i, maxLen);
            } else {
                i = m.get(tmp) + 1;
            }
        }
        return maxLen;
    }
}
