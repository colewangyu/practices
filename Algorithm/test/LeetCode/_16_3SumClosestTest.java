package LeetCode;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by cole on 2016-11-16.
 */
public class _16_3SumClosestTest {
    _16_3SumClosest t;

    @Before
    public void setUp() throws Exception {
        t = new _16_3SumClosest();
    }

    @After
    public void tearDown() throws Exception {
        t = null;
    }

    @Test
    public void threeSumClosest1() throws Exception {
        assertEquals(2, t.threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
    }

    @Test
    public void threeSumClosest2() throws Exception {
        assertEquals(0, t.threeSumClosest(new int[]{0, 0, 0}, 10));
    }

    @Test
    public void threeSumClosest3() throws Exception {
        assertEquals(6, t.threeSumClosest(new int[]{2, 2, 2}, 6));
    }

    @Test
    public void threeSumClosest4() throws Exception {
        assertEquals(3, t.threeSumClosest(new int[]{1,1,1,1}, 100));
    }

    @Test
    public void threeSumClosest5() throws Exception {
        assertEquals(0, t.threeSumClosest(new int[]{0,2,1,-3}, 1));
    }
}