package LeetCode.Hard;

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
        Map<String, Integer> timesMap;
        lenOfWord = words[0].length();
        // map for words
        timesMap = new HashMap<String, Integer>();
        for (String str : words) {
            if (timesMap.containsKey(str)) {
                timesMap.put(str, timesMap.get(str) + 1);
            } else {
                timesMap.put(str, 1);
            }
        }
        // check word one by one
        for (int i = 0; i <= (s.length() - words.length * lenOfWord); i++) {
            Map<String, Integer> tmpTimes = new HashMap<String, Integer>();
            tmpTimes.putAll(timesMap);
            for(int j = 0; j < words.length; j++) {
                // get word one by one
                String str = s.substring(i + j*lenOfWord, i + j*lenOfWord + lenOfWord);
                // match
                if(tmpTimes.containsKey(str)) {
                    int time = tmpTimes.get(str);
                    if(time == 1) {
                        // remove
                        tmpTimes.remove(str);
                        if(tmpTimes.isEmpty()) {
                            result.add(i);
                        }
                    } else {
                        tmpTimes.put(str, time-1);
                    }
                } else {
                    break;
                }
            }
        }
        return result;
    }
}
