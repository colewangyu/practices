package LeetCode;


/**
 * Possible input:
 * ""
 * " "
 * "a"
 * "a "
 * "hello world!"
 */
public class _58_LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        if (s == null)
            throw new NullPointerException();

        s = s.trim();
        if (s.length() == 0)
            return 0;

        int count;
        count = 0;
        for (int i = s.length() - 1; i >= 0 && s.charAt(i) != ' '; i--) {
            count++;
        }
        return count;
    }
}
