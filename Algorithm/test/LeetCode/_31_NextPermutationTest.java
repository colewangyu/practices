package LeetCode;

import LeetCode.Medium._31_NextPermutation;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by wy on 2017-02-10.
 */
public class _31_NextPermutationTest {
    _31_NextPermutation t;

    @Before
    public void setUp() throws Exception {
        t = new _31_NextPermutation();
    }

    @After
    public void tearDown() throws Exception {
        t = null;
    }

    @Test
    public void testNextPermutation01() throws Exception {
        int[] result = new int[]{1,2,3};
        t.nextPermutation(result);
        assertArrayEquals(new int[]{1,3,2}, result);
    }

    @Test
    public void testNextPermutation02() throws Exception {
        int[] result = new int[]{3,2,1};
        t.nextPermutation(result);
        assertArrayEquals(new int[]{1,2,3}, result);
    }

    @Test
    public void testNextPermutation03() throws Exception {
        int[] result = new int[]{1,1,5};
        t.nextPermutation(result);
        assertArrayEquals(new int[]{1,5,1}, result);
    }

    @Test
    public void testNextPermutation04() throws Exception {
        int[] result = new int[]{1,3,2};
        t.nextPermutation(result);
        assertArrayEquals(new int[]{2,1,3}, result);
    }

    @Test
    public void testNextPermutation05() throws Exception {
        int[] result = new int[]{2,3,1};
        t.nextPermutation(result);
        assertArrayEquals(new int[]{3,1,2}, result);
    }

    @Test
    public void testNextPermutation06() throws Exception {
        int[] result = new int[]{5,4,7,5,3,2};
        t.nextPermutation(result);
        assertArrayEquals(new int[]{5,5,2,3,4,7}, result);
    }

    @Test
    public void testNextPermutation07() throws Exception {
        int[] result = new int[]{4,2,0,2,3,2,0};
        t.nextPermutation(result);
        assertArrayEquals(new int[]{4,2,0,3,0,2,2}, result);
    }
}