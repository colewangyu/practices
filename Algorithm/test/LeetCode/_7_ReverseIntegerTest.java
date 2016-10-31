package LeetCode;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by cole on 2016-10-31.
 */
public class _7_ReverseIntegerTest {
    _7_ReverseInteger t;

    @Before
    public void setUp() throws Exception {
        t = new _7_ReverseInteger();
    }

    @After
    public void tearDown() throws Exception {
        t = null;
    }

    @Test
    public void testReverse1() throws Exception {
        assertEquals(321,t.reverse(123));
    }

    @Test
    public void testReverse2() throws Exception {
        assertEquals(-321,t.reverse(-123));
    }

    @Test
    public void testReverse3() throws Exception {
        assertEquals(0,t.reverse(-0));
    }

    @Test
    public void testReverse4() throws Exception {
        assertEquals(0,t.reverse(0));
    }

    @Test
    public void testReverse5() throws Exception {
        assertEquals(1,t.reverse(100));
    }

    @Test
    public void testReverse6() throws Exception {
        assertEquals(-1,t.reverse(-100));
    }
}