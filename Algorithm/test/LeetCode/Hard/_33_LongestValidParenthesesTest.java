package LeetCode.Hard;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class _33_LongestValidParenthesesTest {
    _33_LongestValidParentheses t;

    @Before
    public void setUp() throws Exception {
        t = new _33_LongestValidParentheses();
    }

    @After
    public void tearDown() throws Exception {
        t = null;
    }

    @Test
    public void illigalInput() throws Exception {
        assertEquals(0,t.longestValidParentheses(null));
    }

    @Test
    public void zeroInput() throws Exception {
        assertEquals(0,t.longestValidParentheses(""));
    }

    @Test
    public void invalidWith2Len() throws Exception {
        assertEquals(2,t.longestValidParentheses("(()"));
    }

    @Test
    public void invalidWith4Len() throws Exception {
        assertEquals(4,t.longestValidParentheses(")()())"));
    }

    @Test
    public void invalidAtTailWith4Len() throws Exception {
        assertEquals(4,t.longestValidParentheses("()()("));
    }

    @Test
    public void invalidAtMidWith4Len() throws Exception {
        assertEquals(2,t.longestValidParentheses("())()"));
    }

    @Test
    public void invalidWithOnlyLeftParentheses() throws Exception {
        assertEquals(0,t.longestValidParentheses("(((("));
    }

    @Test
    public void invalidWithManyLeftParentheses() throws Exception {
        assertEquals(2,t.longestValidParentheses("(((()"));
    }

    @Test
    public void validWith2Len() throws Exception {
        assertEquals(2,t.longestValidParentheses("()"));
    }

    @Test
    public void validWith4Len() throws Exception {
        assertEquals(4,t.longestValidParentheses("()()"));
    }

    @Test
    public void validWith4LenInSymmetry() throws Exception {
        assertEquals(4,t.longestValidParentheses("(())"));
    }

    @Test
    public void validWith6Len() throws Exception {
        assertEquals(6,t.longestValidParentheses("(()())"));
    }

}