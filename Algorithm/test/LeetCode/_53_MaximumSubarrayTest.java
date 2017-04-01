package LeetCode;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class _53_MaximumSubarrayTest {
    _53_MaximumSubarray t;
    @Before
    public void setUp() throws Exception {
        t = new _53_MaximumSubarray();
    }

    @After
    public void tearDown() throws Exception {
        t = null;
    }

    @Test
    public void maxSubArray01() throws Exception {
        assertEquals(6, t.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }

    @Test
    public void maxSubArray02() throws Exception {
        assertEquals(-2, t.maxSubArray(new int[]{-2}));
    }

    @Test
    public void maxSubArray03() throws Exception {
        assertEquals(3, t.maxSubArray(new int[]{3}));
    }

    @Test
    public void maxSubArray04() throws Exception {
        assertEquals(0, t.maxSubArray(new int[]{0}));
    }

    @Test
    public void maxSubArray05() throws Exception {
        assertEquals(1, t.maxSubArray(new int[]{-2,1}));
    }

}