package LeetCode;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by wy on 2017-02-17.
 */
public class _46_PermutationsTest {
    _46_Permutations t;

    @Before
    public void setUp() throws Exception {
        t = new _46_Permutations();
    }

    @After
    public void tearDown() throws Exception {
        t = null;
    }

    @Test
    public void testPermute01() throws Exception {
        List<List<Integer>> result;
        result = t.permute(new int[]{1,2,3});
        assertEquals(6, result.size());
        assertArrayEquals(new Object[]{1,2,3}, result.get(0).toArray());
        assertArrayEquals(new Object[]{1,3,2}, result.get(1).toArray());
        assertArrayEquals(new Object[]{2,1,3}, result.get(2).toArray());
        assertArrayEquals(new Object[]{2,3,1}, result.get(3).toArray());
        assertArrayEquals(new Object[]{3,1,2}, result.get(4).toArray());
        assertArrayEquals(new Object[]{3,2,1}, result.get(5).toArray());
    }

    @Test
    public void testPermute02() throws Exception {
        List<List<Integer>> result;
        result = t.permute(new int[]{1});
        assertEquals(1, result.size());
        assertArrayEquals(new Object[]{1}, result.get(0).toArray());
    }


}