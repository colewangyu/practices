package LeetCode.Medium;

import LeetCode.Medium._15_3Sum;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by wy on 2016-11-13.
 */
public class _15_3SumTest {
    _15_3Sum t;

    @Before
    public void setUp() throws Exception {
        t = new _15_3Sum();
    }

    @After
    public void tearDown() throws Exception {
        t = null;
    }

    @Test
    public void testThreeSum1() throws Exception {
        List<List<Integer>> list = t.threeSum(new int[]{-1,0,1,0});
        List<List<Integer>> assertList = new ArrayList<List<Integer>>();
        List<Integer> tmpList = new ArrayList<Integer>();
        tmpList.add(-1);
        tmpList.add(0);
        tmpList.add(1);
        assertList.add(tmpList);
        assertEquals(assertList, list);
    }

    @Test
    public void testThreeSum2() throws Exception {
        List<List<Integer>> list = t.threeSum(new int[]{-1,0,1,2,-1,-4});
        List<List<Integer>> assertList = new ArrayList<List<Integer>>();
        List<Integer> tmpList = new ArrayList<Integer>();
        tmpList.add(-1);
        tmpList.add(-1);
        tmpList.add(2);
        assertList.add(tmpList);
        tmpList = new ArrayList<Integer>();
        tmpList.add(-1);
        tmpList.add(0);
        tmpList.add(1);
        assertList.add(tmpList);
        assertEquals(assertList, list);
    }
    @Test
    public void testThreeSum3() throws Exception {
        List<List<Integer>> list = t.threeSum(new int[]{-2,0,0,2,2});
        List<List<Integer>> assertList = new ArrayList<List<Integer>>();
        List<Integer> tmpList = new ArrayList<Integer>();
        tmpList.add(-2);
        tmpList.add(0);
        tmpList.add(2);
        assertList.add(tmpList);
        assertEquals(assertList, list);
    }
    @Test
    public void testThreeSum4() throws Exception {
        List<List<Integer>> list = t.threeSum(new int[]{0,0,0});
        List<List<Integer>> assertList = new ArrayList<List<Integer>>();
        List<Integer> tmpList = new ArrayList<Integer>();
        tmpList.add(0);
        tmpList.add(0);
        tmpList.add(0);
        assertList.add(tmpList);
        assertEquals(assertList, list);
    }
    @Test
    public void testThreeSum5() throws Exception {
        List<List<Integer>> list = t.threeSum(new int[]{-2,0,1,1,2});
        List<List<Integer>> assertList = new ArrayList<List<Integer>>();
        List<Integer> tmpList = new ArrayList<Integer>();
        tmpList.add(-2);
        tmpList.add(0);
        tmpList.add(2);
        assertList.add(tmpList);
        tmpList = new ArrayList<Integer>();
        tmpList.add(-2);
        tmpList.add(1);
        tmpList.add(1);
        assertList.add(tmpList);
        assertEquals(assertList, list);
    }
}