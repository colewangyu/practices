package LeetCode;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by wy on 2017-02-16.
 */
public class _40_CombinationSumIITest {
    _40_CombinationSumII t;

    @Before
    public void setUp() throws Exception {
        t = new _40_CombinationSumII();
    }

    @After
    public void tearDown() throws Exception {
        t = null;
    }

    @Test
    public void testCombinationSum2_01() throws Exception {
        List<List<Integer>> result;
        result = t.combinationSum2(new int[]{2,3,6,7}, 7);
        assertEquals(1, result.size());
        assertArrayEquals(new Object[]{7}, result.get(0).toArray());
    }

    @Test
    public void testCombinationSum2_02() throws Exception {
        List<List<Integer>> result;
        result = t.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
        assertEquals(4, result.size());
        assertArrayEquals(new Object[]{1,1,6}, result.get(0).toArray());
        assertArrayEquals(new Object[]{1,2,5}, result.get(1).toArray());
        assertArrayEquals(new Object[]{1,7}, result.get(2).toArray());
        assertArrayEquals(new Object[]{2,6}, result.get(3).toArray());
    }

    @Test
    public void testCombinationSum2_03() throws Exception {
        List<List<Integer>> result;
        result = t.combinationSum2(new int[]{1,1}, 1);
        assertEquals(1, result.size());
        assertArrayEquals(new Object[]{1}, result.get(0).toArray());
    }

    @Test
    public void testCombinationSum2_04() throws Exception {
        List<List<Integer>> result;
        result = t.combinationSum2(new int[]{2,5,2,1,2}, 5);
        assertEquals(2, result.size());
        assertArrayEquals(new Object[]{1,2,2}, result.get(0).toArray());
        assertArrayEquals(new Object[]{5}, result.get(1).toArray());
    }

    @Test
    public void testCombinationSum2_05() throws Exception {
        List<List<Integer>> result;
        result = t.combinationSum2(new int[]{2,2,2,2}, 6);
        assertEquals(1, result.size());
        assertArrayEquals(new Object[]{2,2,2}, result.get(0).toArray());
    }

    @Test
    public void testCombinationSum2_06() throws Exception {
        List<List<Integer>> result;
        result = t.combinationSum2(new int[]{1,1,1,1,2,2,2,2}, 6);
        assertEquals(3, result.size());
        assertArrayEquals(new Object[]{1,1,1,1,2}, result.get(0).toArray());
        assertArrayEquals(new Object[]{1,1,2,2}, result.get(1).toArray());
        assertArrayEquals(new Object[]{2,2,2}, result.get(2).toArray());
    }
}