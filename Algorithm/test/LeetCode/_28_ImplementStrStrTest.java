package LeetCode;

import LeetCode.Easy._28_ImplementStrStr;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by cole on 2016-12-04.
 */
public class _28_ImplementStrStrTest {
    _28_ImplementStrStr t;

    @Before
    public void setUp() throws Exception {
        t = new _28_ImplementStrStr();
    }

    @After
    public void tearDown() throws Exception {
        t = null;
    }

    @Test
    public void testStrStr1() throws Exception {
        assertEquals(0, t.strStr("ss", "s"));
    }

    @Test
    public void testStrStr2() throws Exception {
        assertEquals(0, t.strStr("sa", "sa"));
    }

    @Test
    public void testStrStr3() throws Exception {
        assertEquals(2, t.strStr("sst", "t"));
    }

    @Test
    public void testStrStr4() throws Exception {
        assertEquals(0, t.strStr("", ""));
    }

    @Test
    public void testStrStr5() throws Exception {
        assertEquals(-1, t.strStr("ss", "sss"));
    }

    @Test
    public void testStrStr6() throws Exception {
        assertEquals(0, t.strStr("a", ""));
    }

    @Test
    public void testStrStr7() throws Exception {
        assertEquals(-1, t.strStr("asdfg", "c"));
    }

}