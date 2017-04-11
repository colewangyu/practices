package LeetCode;

import LeetCode.Medium._22_GenerateParentheses;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by wy on 2016-11-29.
 */
public class _22_GenerateParenthesesTest {
    _22_GenerateParentheses t;

    @Before
    public void setUp() throws Exception {
        t = new _22_GenerateParentheses();
    }

    @After
    public void tearDown() throws Exception {
        t = null;
    }

    @Test
    public void testGenerateParenthesis1() throws Exception {
        List<String> expect = new ArrayList<String>();
        expect.add("((()))");
        expect.add("(()())");
        expect.add("(())()");
        expect.add("()(())");
        expect.add("()()()");
        assertEquals(expect, t.generateParenthesis(3));
    }

    @Test
    public void testGenerateParenthesis2() throws Exception {
        List<String> expect = new ArrayList<String>();
        expect.add("()");
        assertEquals(expect, t.generateParenthesis(1));
    }

    @Test
    public void testGenerateParenthesis3() throws Exception {
        List<String> expect = new ArrayList<String>();
        expect.add("(())");
        expect.add("()()");
        assertEquals(expect, t.generateParenthesis(2));
    }
}