package LeetCode.Easy;

import LeetCode.Easy._14_LongestCommonPrefix;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by wy on 2016-11-14.
 */
public class _14_LongestCommonPrefixTest {
    _14_LongestCommonPrefix t;

    @Before
    public void setUp() throws Exception {
        t = new _14_LongestCommonPrefix();
    }

    @After
    public void tearDown() throws Exception {
        t = null;
    }

    @Test
    public void testLongestCommonPrefix1() throws Exception {
        assertEquals("abc_", t.longestCommonPrefix(new String[]{"abc_1","abc_2","abc_3"}));
    }

    @Test
    public void testLongestCommonPrefix2() throws Exception {
        assertEquals("", t.longestCommonPrefix(new String[]{"1","a2","b3"}));
    }
}