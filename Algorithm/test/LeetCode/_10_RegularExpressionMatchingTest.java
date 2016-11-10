package LeetCode;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by wy on 2016-11-09.
 */
public class _10_RegularExpressionMatchingTest {
    _10_RegularExpressionMatching t;

    @Before
    public void setUp() throws Exception {
        t = new _10_RegularExpressionMatching();
    }

    @After
    public void tearDown() throws Exception {
        t = null;
    }

    /*
       有效输入：
       1. pattern仅含有普通字符
       2. pattern仅含有.
       3. pattern含有普通字符和*
       4. pattern含有普通字符和.
       5. pattern含有普通字符、*、.
       6. pattern含有*、.
     */
    @Test
    public void testIsMatch1() throws Exception {
        assertTrue(t.isMatch("aa", "aa"));
        assertFalse(t.isMatch("aa", "a"));
        assertFalse(t.isMatch("a", "aa"));
    }

    @Test
    public void testIsMatch2() throws Exception {
        assertTrue(t.isMatch(" ", "."));
        assertTrue(t.isMatch("a", "."));
        assertFalse(t.isMatch("a ", "."));
    }

    @Test
    public void testIsMatch3() throws Exception {
        assertTrue(t.isMatch("aaa", "a*"));
        assertFalse(t.isMatch("aab", "a*"));
    }

    @Test
    public void testIsMatch4() throws Exception {
        assertTrue(t.isMatch("ab", "a*."));
        assertFalse(t.isMatch("abc", "a*."));
    }

    @Test
    public void testIsMatch5() throws Exception {
        assertTrue(t.isMatch("aa", ".*"));
        assertTrue(t.isMatch("", ".*"));
        assertTrue(t.isMatch("**", ".*"));
        assertTrue(t.isMatch("..", ".*"));
    }
    @Test
    public void testIsMatch6() throws Exception {
        assertFalse(t.isMatch("ab",".*c"));
        assertTrue(t.isMatch("acc","ac*cc"));
    }

    @Test
    public void testIsMatch7() throws Exception {
        assertTrue(t.isMatch("aab","c*a*b"));
    }

    @Test
    public void testIsMatch8() throws Exception {
        assertTrue(t.isMatch("","c*a*"));
    }
}