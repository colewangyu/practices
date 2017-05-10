package LeetCode.Medium;

import LeetCode.Medium._50_Pow;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class _50_PowTest {
    _50_Pow t;
    @Before
    public void setUp() throws Exception {
        t = new _50_Pow();
    }

    @After
    public void tearDown() throws Exception {
        t = null;
    }

    @Test
    public void myPow01() throws Exception {
        assertEquals(1, t.myPow(2,0), 0.000000001);
    }

    @Test
    public void myPow02() throws Exception {
        assertEquals(2, t.myPow(2,1), 0.000000001);
    }

    @Test
    public void myPow03() throws Exception {
        assertEquals(4, t.myPow(2,2), 0.00001);
    }

    @Test
    public void myPow04() throws Exception {
        assertEquals(0.5, t.myPow(2,-1), 0.00001);
    }

    @Test
    public void myPow05() throws Exception {
        assertEquals(0.25, t.myPow(2,-2), 0.00001);
    }

    @Test
    public void myPow06() throws Exception {
        assertEquals(700.28148, t.myPow(8.88023,3), 0.00001);
    }

    @Test
    public void myPow07() throws Exception {
        assertEquals(0, t.myPow(0.00001,2147483647), 0.00001);
    }

    @Test
    public void myPow08() throws Exception {
        assertEquals(0.00003, t.myPow(34.00515,-3), 0.00001);
    }

    @Test
    public void myPow09() throws Exception {
        assertEquals(0.00009, t.myPow(4.70975,-6), 0.00001);
    }

    @Test
    public void myPow10() throws Exception {
        assertEquals(700.28148, t.myPow(8.88023,3), 0.00001);
    }

    @Test
    public void myPow11() throws Exception {
        assertEquals(0.00002, t.myPow(8.84372,-5), 0.00001);
    }
}