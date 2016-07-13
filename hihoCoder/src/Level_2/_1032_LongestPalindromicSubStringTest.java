package Level_2;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by cole on 2016-05-16 Monday.
 */
public class _1032_LongestPalindromicSubStringTest {

    @Test
    public void testGetLengthOfLongestPalindromicSubString() throws Exception {
        _1032_LongestPalindromicSubString t = new _1032_LongestPalindromicSubString();
        assertEquals(5, t.getLengthOfLongestPalindromicSubString("abcba"));
        assertEquals(6, t.getLengthOfLongestPalindromicSubString("abccba"));
        assertEquals(5, t.getLengthOfLongestPalindromicSubString("aaaaa"));
        assertEquals(9, t.getLengthOfLongestPalindromicSubString("aaabbbaaa"));
        assertEquals(7, t.getLengthOfLongestPalindromicSubString("ababcbab"));
        assertEquals(3, t.getLengthOfLongestPalindromicSubString("abcdeda"));
        assertEquals(6, t.getLengthOfLongestPalindromicSubString("abcbdeedba"));
        assertEquals(1, t.getLengthOfLongestPalindromicSubString("abcdef"));
    }
}