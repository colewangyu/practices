package LeetCode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 * <p>
 * For example,
 * S = "ADOBECODEBANC"
 * T = "ABC"
 * Minimum window is "BANC".
 * <p>
 * Note:
 * If there is no such window in S that covers all characters in T, return the empty string "".
 * <p>
 * If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
 * <p>
 */
public class _76_MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        // check input validation
        if (s == null || t == null || s.length() == 0 || t.length() == 0 || s.length() < t.length())
            return "";

        String result;
        Map<Character, Integer> statusMap;
        Map<Character, Integer> targetMap;
        int leftIndex;
        int rightIndex;
        int minLeftIndex;
        int minRightIndex;
        int minLength;
        boolean leftFlag;
        boolean rightFlag;
        statusMap = new HashMap<Character, Integer>();
        targetMap = new HashMap<Character, Integer>();
        leftIndex = 0;
        rightIndex = 0;

        leftFlag = true;
        char tmp;
        // create targetMap using t
        for (char c : t.toCharArray()) {
            if (targetMap.containsKey(c)) {
                targetMap.put(c, targetMap.get(c) + 1);
            } else {
                targetMap.put(c, 1);
            }
        }
        // find first window
        for (char c : s.toCharArray()) {
            if (targetMap.containsKey(c)) {
                if (statusMap.containsKey(c)) {
                    statusMap.put(c, statusMap.get(c) + 1);
                } else {
                    statusMap.put(c, 1);
                }
                if (isSatisfy(statusMap, targetMap)) {
                    rightIndex++;
                    break;
                }
            }
            rightIndex++;
        }
        if (!isSatisfy(statusMap, targetMap)) {
            return "";
        }
        minLeftIndex = leftIndex;
        minRightIndex = rightIndex;
        minLength = minRightIndex - minLeftIndex;
        // create statusMap using s
        while (leftIndex < rightIndex) {
            if (isSatisfy(statusMap, targetMap)) {
                if ((rightIndex - leftIndex) < minLength) {
                    minLength = rightIndex - leftIndex;
                    minRightIndex = rightIndex;
                    minLeftIndex = leftIndex;
                }
                // add leftIndex
                tmp = s.charAt(leftIndex);
                if (targetMap.containsKey(tmp))
                    statusMap.put(tmp, statusMap.get(tmp) - 1);
                    leftIndex++;
            } else if (rightIndex < s.length()) {
                // add rightIndex
                tmp = s.charAt(rightIndex);
                if (targetMap.containsKey(tmp))
                    statusMap.put(tmp, statusMap.get(tmp) + 1);
                rightIndex++;
            } else {
                break;
            }
        }
        result = s.substring(minLeftIndex, minRightIndex);
        return result;
    }

    private static boolean isSatisfy(Map<Character, Integer> statusMap, Map<Character, Integer> targetMap) {
        if (statusMap.size() != targetMap.size())
            return false;
        Iterator<Character> it = statusMap.keySet().iterator();
        while (it.hasNext()) {
            char tmp = it.next();
            if (statusMap.get(tmp) < targetMap.get(tmp))
                return false;
        }
        return true;
    }
}
