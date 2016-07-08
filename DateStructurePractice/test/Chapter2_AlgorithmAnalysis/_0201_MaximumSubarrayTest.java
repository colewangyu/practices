package Chapter2_AlgorithmAnalysis;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by wy on 2016-05-16.
 */
public class _0201_MaximumSubarrayTest {

    @Test
    public void testGetMaxsubarraySum1() throws Exception {

    }

    @Test
    public void testGetMaxsubarraySum2() throws Exception {

    }

    @Test
    public void testGetMaxsubarraySum4() throws Exception {
        _0201_MaximumSubarray t = new _0201_MaximumSubarray();
        assertEquals(-1,t.getMaxsubarraySum4(new int[]{-2,-1}));
    }
}