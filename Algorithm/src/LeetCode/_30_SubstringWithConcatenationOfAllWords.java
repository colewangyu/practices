package LeetCode;

import java.util.*;

/**
 * You are given a string, s, and a list of words, words, that are all of the same length.
 * Find all starting indices of substring(s) in s that is a concatenation of each word
 * in words exactly once and without any intervening characters.
 * <p>
 * For example, given:
 * s: "barfoothefoobarman"
 * words: ["foo", "bar"]
 * <p>
 * You should return the indices: [0,9].
 * (order does not matter).
 */
public class _30_SubstringWithConcatenationOfAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<Integer>();
        if (s == null || words == null || s.length() == 0 || words.length == 0)
            return result;

        int lenOfWord;
        Map<String, Integer> times;
        lenOfWord = words[0].length();
        times = new HashMap<String, Integer>();
        for (String str : words) {
            if (times.containsKey(str)) {
                times.put(str, times.get(str) + 1);
            } else {
                times.put(str, 1);
            }
        }

        for (int i = 0; i <= (s.length() - words.length * lenOfWord); i++) {
            Map<String, Integer> tmpTimes = new HashMap<String, Integer>();
            tmpTimes.putAll(times);
            findSubstring(s, words, tmpTimes, i, i, result, lenOfWord);
        }
        return result;
    }

    private void findSubstring(String s, String[] words, Map<String, Integer> times, int startIndex, int index, List<Integer> result, int lenOfWord) {
        if (isASubstring(times)) {
            result.add(startIndex);
            return;
        }

        String word = s.substring(index, index + lenOfWord);
        if (isContain(words, times, word)) {
            times.put(word, times.get(word) - 1);
            Map<String, Integer> tmpTimes = new HashMap<String, Integer>();
            tmpTimes.putAll(times);
            findSubstring(s, words, tmpTimes, startIndex, index + lenOfWord, result, lenOfWord);
        }
    }

    private boolean isContain(String[] words, Map<String, Integer> times, String word) {
        for (String s : words) {
            if (s.equals(word) && times.get(word) > 0) {
                return true;
            }
        }
        return false;
    }

    private boolean isASubstring(Map<String, Integer> times) {
        Iterator<String> it = times.keySet().iterator();
        while (it.hasNext()) {
            if (times.get(it.next()) != 0)
                return false;
        }
        return true;
    }
}
