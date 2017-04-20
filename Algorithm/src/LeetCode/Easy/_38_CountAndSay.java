package LeetCode.Easy;

/**
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ...
 * <p>
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 */
public class _38_CountAndSay {
    public String countAndSay(int n) {
        String result;
        result = "1";
        for (int i = 1; i < n; i++) {
            result = countAndSay(result);
        }
        return result;
    }

    private String countAndSay(String s) {
        StringBuilder result;
        result = new StringBuilder();

        int count;
        char prev;
        char cur;
        char[] chars;

        chars = s.toCharArray();
        count = 1;
        for (int i = 0; i < chars.length; i++) {
            prev = chars[i];
            if(i + 1 < chars.length) {
                cur = chars[i + 1];
                if (prev == cur) {
                    count++;
                } else {
                    result.append(count).append(prev);
                    count = 1;
                }
            } else {
                result.append(count).append(prev);
            }
        }
        return result.toString();
    }
}
