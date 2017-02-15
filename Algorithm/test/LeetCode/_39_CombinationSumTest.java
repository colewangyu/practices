package LeetCode;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class _39_CombinationSumTest {
    _39_CombinationSum t;

    @Before
    public void setUp() throws Exception {
        t = new _39_CombinationSum();
    }

    @After
    public void tearDown() throws Exception {
        t = null;
    }

    @Test
    public void combinationSum01() throws Exception {
        List<List<Integer>> result;
        result = t.combinationSum(new int[]{2,3,6,7}, 7);
        assertEquals(2, result.size());
        assertArrayEquals(new Object[]{2,2,3}, result.get(0).toArray());
        assertArrayEquals(new Object[]{7}, result.get(1).toArray());
    }

    @Test
    public void combinationSum02() throws Exception {
        List<List<Integer>> result;
        result = t.combinationSum(new int[]{4,2,6,9}, 8);
        assertEquals(4, result.size());
        assertArrayEquals(new Object[]{2,2,2,2}, result.get(0).toArray());
        assertArrayEquals(new Object[]{2,2,4}, result.get(1).toArray());
        assertArrayEquals(new Object[]{2,6}, result.get(2).toArray());
        assertArrayEquals(new Object[]{4,4}, result.get(3).toArray());
    }

    @Test
    public void combinationSum03() throws Exception {
        List<List<Integer>> result;
        result = t.combinationSum(new int[]{4,2,6,9}, 1);
        assertEquals(0, result.size());
    }

}