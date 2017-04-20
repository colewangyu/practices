package LeetCode;

import LeetCode.Easy._9_PalindromeNumber;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by wy on 2016-11-14.
 */
public class _9_PalindromeNumberTest {
    _9_PalindromeNumber t;

    @Before
    public void setUp() throws Exception {
        t = new _9_PalindromeNumber();
    }

    @After
    public void tearDown() throws Exception {
        t = null;
    }

    @Test
    public void testIsPalindrome1() throws Exception {
        assertTrue(t.isPalindrome(12321));
    }

    @Test
    public void testIsPalindrome2() throws Exception {
        assertTrue(t.isPalindrome(123321));
    }

    @Test
    public void testIsPalindrome3() throws Exception {
        assertFalse(t.isPalindrome(1233211));
    }
}