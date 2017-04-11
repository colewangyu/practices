package LeetCode;

import LeetCode.Medium._3_LongestSubstringWithoutRepeatingCharacters;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by wy on 2016-11-14.
 */
public class _3_LongestSubstringWithoutRepeatingCharactersTest {
    _3_LongestSubstringWithoutRepeatingCharacters t;

    @Before
    public void setUp() throws Exception {
        t = new _3_LongestSubstringWithoutRepeatingCharacters();
    }

    @After
    public void tearDown() throws Exception {
        t = null;
    }

    @Test
    public void testLengthOfLongestSubstring1() throws Exception {
        assertEquals(3, t.lengthOfLongestSubstring("abcabcbb"));
    }

    @Test
    public void testLengthOfLongestSubstring2() throws Exception {
        assertEquals(1, t.lengthOfLongestSubstring("bbbbb"));
    }

    @Test
    public void testLengthOfLongestSubstring3() throws Exception {
        assertEquals(3, t.lengthOfLongestSubstring("pwwkew"));
    }
}