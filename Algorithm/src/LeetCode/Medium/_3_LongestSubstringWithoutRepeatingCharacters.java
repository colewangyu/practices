package LeetCode.Medium;

import java.util.HashMap;

/**
 * Created by wy on 2016-11-14.
 */
public class _3_LongestSubstringWithoutRepeatingCharacters {
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
