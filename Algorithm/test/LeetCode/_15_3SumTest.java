package LeetCode;

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

    private void assertArray(List<List<Integer>> list, List<List<Integer>> assertList) {
        if(list.size() != assertList.size())
            fail();

        List<Integer> tmpList;
        List<Integer> assertTmpList;

        for(int i = 0; i < list.size() ; i++) {
            tmpList = list.get(i);
            assertTmpList = assertList.get(i);
            assertEquals(assertTmpList.get(0), tmpList.get(0));
            assertEquals(assertTmpList.get(1), tmpList.get(1));
            assertEquals(assertTmpList.get(2), tmpList.get(2));
        }
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

        assertArray(list, assertList);
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

        assertArray(list, assertList);
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

        assertArray(list, assertList);
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

        assertArray(list, assertList);
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

        assertArray(list, assertList);
    }
}