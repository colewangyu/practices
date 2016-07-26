import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by cole on 2016-05-15 Sunday.
 */
public class _5_longestPalindromeTest {

    @Test
    public void testLongestPalindrome() throws Exception {
        _5_longestPalindrome t = new _5_longestPalindrome();
        assertEquals("abcba", t.longestPalindrome("abcba"));
        assertEquals("abccba", t.longestPalindrome("abccba"));
        assertEquals("aaaaa", t.longestPalindrome("aaaaa"));
        assertEquals("aaabbbaaa", t.longestPalindrome("aaabbbaaa"));
        assertEquals("babcbab", t.longestPalindrome("ababcbab"));
        assertEquals("ded", t.longestPalindrome("abcdeda"));
        assertEquals("bdeedb", t.longestPalindrome("abcbdeedba"));
        assertEquals("a", t.longestPalindrome("abcdef"));
    }
}