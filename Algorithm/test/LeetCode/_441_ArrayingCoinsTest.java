package LeetCode;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class _441_ArrayingCoinsTest {
    _441_ArrayingCoins t;

    @Before
    public void setUp() throws Exception {
        t = new _441_ArrayingCoins();
    }

    @After
    public void tearDown() throws Exception {
        t = null;
    }

    @Test
    public void arrangeCoins01() throws Exception {
        assertEquals(1, t.arrangeCoins(1));
    }

    @Test
    public void arrangeCoins02() throws Exception {
        assertEquals(1, t.arrangeCoins(2));
    }

    @Test
    public void arrangeCoins03() throws Exception {
        assertEquals(4, t.arrangeCoins(10));
    }

    @Test
    public void arrangeCoins04() throws Exception {
        assertEquals(60070, t.arrangeCoins(1804289383));
    }

}