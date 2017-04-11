package LeetCode;

import LeetCode.Easy._20_ValidParentheses;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by cole on 2016-11-24.
 */
public class _20_ValidParenthesesTest {
    _20_ValidParentheses t;

    @Before
    public void setUp() throws Exception {
        t = new _20_ValidParentheses();
    }

    @After
    public void tearDown() throws Exception {
        t = null;
    }

    @Test
    public void isValid1() throws Exception {
        assertTrue(t.isValid("()"));
    }

    @Test
    public void isValid2() throws Exception {
        assertTrue(t.isValid("[]"));
    }

    @Test
    public void isValid3() throws Exception {
        assertTrue(t.isValid("([])"));
    }

    @Test
    public void isValid4() throws Exception {
        assertTrue(t.isValid("(())"));
    }

    @Test
    public void isValid5() throws Exception {
        assertTrue(t.isValid("([]{})"));
    }

    @Test
    public void isValid6() throws Exception {
        assertTrue(t.isValid("()[]{}"));
    }
    @Test
    public void isValid7() throws Exception {
        assertTrue(t.isValid("{}"));
    }
    @Test
    public void isValid8() throws Exception {
        assertTrue(t.isValid("({(())}[({}){[]}])"));
    }

    @Test
    public void isValid9() throws Exception {
        assertFalse(t.isValid(")"));
    }

    @Test
    public void isValid10() throws Exception {
        assertFalse(t.isValid("["));
    }

    @Test
    public void isValid11() throws Exception {
        assertFalse(t.isValid("[]({}"));
    }

    @Test
    public void isValid12() throws Exception {
        assertFalse(t.isValid("([]({}))}"));
    }

}