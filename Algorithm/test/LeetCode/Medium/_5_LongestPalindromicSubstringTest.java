package LeetCode.Medium;

import LeetCode.Medium._5_LongestPalindromicSubstring;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by wy on 2016-11-14.
 */
public class _5_LongestPalindromicSubstringTest {
    _5_LongestPalindromicSubstring t;

    @Before
    public void setUp() throws Exception {
        t = new _5_LongestPalindromicSubstring();
    }

    @After
    public void tearDown() throws Exception {
        t = null;
    }

    @Test
    public void testLongestPalindrome1() throws Exception {
        assertEquals("bab", t.longestPalindrome("babad"));
    }

    @Test
    public void testLongestPalindrome2() throws Exception {
        assertEquals("bb", t.longestPalindrome("cbbd"));
    }
}