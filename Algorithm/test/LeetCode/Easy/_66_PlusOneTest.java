package LeetCode.Easy;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class _66_PlusOneTest {
    _66_PlusOne t;

    @Before
    public void setUp() throws Exception {
        t = new _66_PlusOne();
    }

    @After
    public void tearDown() throws Exception {
        t = null;
    }

    @Test
    public void plusOne_normalPlus() throws Exception {
        assertArrayEquals(new int[]{1}, t.plusOne(new int[]{0}));
    }

    @Test
    public void plusOne_Carry2() throws Exception {
        assertArrayEquals(new int[]{1,0,0}, t.plusOne(new int[]{9,9}));
    }

    @Test
    public void plusOne_Carry1() throws Exception {
        assertArrayEquals(new int[]{2,0}, t.plusOne(new int[]{1,9}));
    }

}