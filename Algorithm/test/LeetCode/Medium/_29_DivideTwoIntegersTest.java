package LeetCode.Medium;

import LeetCode.Medium._29_DivideTwoIntegers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by cole on 2016-12-04.
 */
public class _29_DivideTwoIntegersTest {
    _29_DivideTwoIntegers t;

    @Before
    public void setUp() throws Exception {
        t = new _29_DivideTwoIntegers();
    }

    @After
    public void tearDown() throws Exception {
        t = null;
    }

    /*
        1. 正数能除尽
        2. 正数不能除尽
        3. 负数能除尽
        4. 负数不能除尽
        5. 被除数为0
        6. 被除数为1
        7. overflow
     */
    @Test
    public void testDivide1() throws Exception {
        assertEquals(2, t.divide(4, 2));
        assertEquals(-2, t.divide(4, -2));
    }

    @Test
    public void testDivide2() throws Exception {
        assertEquals(2, t.divide(5, 2));
        assertEquals(-2, t.divide(5, -2));
    }

    @Test
    public void testDivide3() throws Exception {
        assertEquals(-2, t.divide(-4, 2));
        assertEquals(2, t.divide(-4, -2));
    }

    @Test
    public void testDivide4() throws Exception {
        assertEquals(-2, t.divide(-5, 2));
        assertEquals(2, t.divide(-5, -2));
    }

    @Test
    public void testDivide5() throws Exception {
        assertEquals(0, t.divide(0, 2));
    }

    @Test
    public void testDivide6() throws Exception {
        assertEquals(4, t.divide(4, 1));
        assertEquals(-4, t.divide(4, -1));
    }

    @Test
    public void testDivide7() throws Exception {
        assertEquals(Integer.MAX_VALUE, t.divide(-2147483648, -1));
    }

    @Test
    public void testDivide8() throws Exception {
        assertEquals(1, t.divide(1, 1));
    }

    @Test
    public void testDivide9() throws Exception {
        assertEquals(3, t.divide(19, 5));
    }

    @Test
    public void testDivide10() throws Exception {
        assertEquals(Integer.MAX_VALUE, t.divide(Integer.MAX_VALUE, 1));
    }

    @Test
    public void testDivide11() throws Exception {
        assertEquals(Integer.MIN_VALUE, t.divide(Integer.MIN_VALUE, 1));
    }

    @Test
    public void testDivide12() throws Exception {
        assertEquals(0, t.divide(1, Integer.MIN_VALUE));
    }

    @Test
    public void testDivide13() throws Exception {
        assertEquals(1, t.divide(Integer.MIN_VALUE, Integer.MIN_VALUE));
    }

    @Test
    public void testDivide14() throws Exception {
        assertEquals(1, t.divide(Integer.MIN_VALUE, Integer.MIN_VALUE + 1));
    }

}