package LeetCode.Medium;

import LeetCode.Medium._34_Search4ARange;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by wy on 2017-02-13.
 */
public class _34_Search4ARangeTest {
    private _34_Search4ARange t;

    @Before
    public void setUp() throws Exception {
        t = new _34_Search4ARange();
    }

    @After
    public void tearDown() throws Exception {
        t = null;
    }

    @Test
    public void testSearchRange01() throws Exception {
        int[] result;
        result = t.searchRange(new int[]{5,7,7,8,8,10},8);
        assertEquals(2,result.length);
        assertEquals(3,result[0]);
        assertEquals(4,result[1]);
    }

    @Test
    public void testSearchRange02() throws Exception {
        int[] result;
        result = t.searchRange(new int[]{5,7,7,10},8);
        assertEquals(2,result.length);
        assertEquals(-1,result[0]);
        assertEquals(-1,result[1]);
    }

    @Test
    public void testSearchRange03() throws Exception {
        int[] result;
        result = t.searchRange(new int[]{5,7,7,8,10},8);
        assertEquals(2,result.length);
        assertEquals(3,result[0]);
        assertEquals(3,result[1]);
    }

    @Test
    public void testSearchRange04() throws Exception {
        int[] result;
        result = t.searchRange(new int[]{8},8);
        assertEquals(2,result.length);
        assertEquals(0,result[0]);
        assertEquals(0,result[1]);
    }

    @Test
    public void testSearchRange05() throws Exception {
        int[] result;
        result = t.searchRange(new int[]{5},8);
        assertEquals(2,result.length);
        assertEquals(-1,result[0]);
        assertEquals(-1,result[1]);
    }
}