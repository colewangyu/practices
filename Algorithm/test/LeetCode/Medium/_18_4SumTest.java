package LeetCode.Medium;

import LeetCode.Medium._18_4Sum;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by cole on 2016-11-23.
 */
public class _18_4SumTest {
    _18_4Sum t;

    @Before
    public void setUp() throws Exception {
        t = new _18_4Sum();
    }

    @After
    public void tearDown() throws Exception {
        t = null;
    }

    @Test
    public void fourSum1() throws Exception {
        List<List<Integer>> list = t.fourSum(new int[]{-1,0,1,0},0);
        List<List<Integer>> assertList = new ArrayList<List<Integer>>();
        List<Integer> tmpList = new ArrayList<Integer>();
        tmpList.add(-1);
        tmpList.add(0);
        tmpList.add(0);
        tmpList.add(1);
        assertList.add(tmpList);
        assertEquals(assertList, list);
    }

    @Test
    public void fourSum2() throws Exception {
        List<List<Integer>> list = t.fourSum(new int[]{1, 0, -1, 0, -2, 2},0);
        List<List<Integer>> assertList = new ArrayList<List<Integer>>();
        List<Integer> tmpList;
        tmpList = new ArrayList<Integer>();
        tmpList.add(-2);
        tmpList.add(-1);
        tmpList.add(1);
        tmpList.add(2);
        assertList.add(tmpList);
        tmpList = new ArrayList<Integer>();
        tmpList.add(-2);
        tmpList.add(0);
        tmpList.add(0);
        tmpList.add(2);
        assertList.add(tmpList);
        tmpList = new ArrayList<Integer>();
        tmpList.add(-1);
        tmpList.add(0);
        tmpList.add(0);
        tmpList.add(1);
        assertList.add(tmpList);
        assertEquals(assertList, list);
    }

    @Test
    public void fourSum3() throws Exception {
        List<List<Integer>> list = t.fourSum(new int[]{0,0,0,0},0);
        List<List<Integer>> assertList = new ArrayList<List<Integer>>();
        List<Integer> tmpList = new ArrayList<Integer>();
        tmpList.add(0);
        tmpList.add(0);
        tmpList.add(0);
        tmpList.add(0);
        assertList.add(tmpList);
        assertEquals(assertList, list);
    }

    @Test
    public void fourSum4() throws Exception {
        List<List<Integer>> list = t.fourSum(new int[]{-3,-2,-1,0,0,1,2,3},0);
        List<List<Integer>> assertList = new ArrayList<List<Integer>>();
        List<Integer> tmpList;
        tmpList = new ArrayList<Integer>();
        tmpList.add(-3);
        tmpList.add(-2);
        tmpList.add(2);
        tmpList.add(3);
        assertList.add(tmpList);
        tmpList = new ArrayList<Integer>();
        tmpList.add(-3);
        tmpList.add(-1);
        tmpList.add(1);
        tmpList.add(3);
        assertList.add(tmpList);
        tmpList = new ArrayList<Integer>();
        tmpList.add(-3);
        tmpList.add(0);
        tmpList.add(0);
        tmpList.add(3);
        assertList.add(tmpList);
        tmpList = new ArrayList<Integer>();
        tmpList.add(-3);
        tmpList.add(0);
        tmpList.add(1);
        tmpList.add(2);
        assertList.add(tmpList);
        tmpList = new ArrayList<Integer>();
        tmpList.add(-2);
        tmpList.add(-1);
        tmpList.add(0);
        tmpList.add(3);
        assertList.add(tmpList);
        tmpList = new ArrayList<Integer>();
        tmpList.add(-2);
        tmpList.add(-1);
        tmpList.add(1);
        tmpList.add(2);
        assertList.add(tmpList);
        tmpList = new ArrayList<Integer>();
        tmpList.add(-2);
        tmpList.add(0);
        tmpList.add(0);
        tmpList.add(2);
        assertList.add(tmpList);
        tmpList = new ArrayList<Integer>();
        tmpList.add(-1);
        tmpList.add(0);
        tmpList.add(0);
        tmpList.add(1);
        assertList.add(tmpList);
        assertEquals(assertList, list);
    }

    @Test
    public void fourSum5() throws Exception {
        List<List<Integer>> list = t.fourSum(new int[]{-1,0,1,2,-1,-4},-1);
        List<List<Integer>> assertList = new ArrayList<List<Integer>>();
        List<Integer> tmpList;
        tmpList = new ArrayList<Integer>();
        tmpList.add(-4);
        tmpList.add(0);
        tmpList.add(1);
        tmpList.add(2);
        assertList.add(tmpList);
        tmpList = new ArrayList<Integer>();
        tmpList.add(-1);
        tmpList.add(-1);
        tmpList.add(0);
        tmpList.add(1);
        assertList.add(tmpList);
        assertEquals(assertList, list);
    }
}