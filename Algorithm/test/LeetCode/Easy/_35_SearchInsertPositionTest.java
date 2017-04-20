package LeetCode.Easy;

import LeetCode.Easy._35_SearchInsertPosition;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by wy on 2017-02-06.
 */
public class _35_SearchInsertPositionTest {
    _35_SearchInsertPosition t;

    @Before
    public void setUp() throws Exception {
        t = new _35_SearchInsertPosition();
    }

    @After
    public void tearDown() throws Exception {
        t = null;
    }

    @Test
    public void testSearchInsert01() throws Exception {
        assertEquals(2,t.searchInsert(new int[]{1,3,5,6},5));
    }
    @Test
    public void testSearchInsert02() throws Exception {
        assertEquals(1,t.searchInsert(new int[]{1,3,5,6},2));
    }
    @Test
    public void testSearchInsert03() throws Exception {
        assertEquals(4,t.searchInsert(new int[]{1,3,5,6},7));
    }
    @Test
    public void testSearchInsert04() throws Exception {
        assertEquals(0,t.searchInsert(new int[]{1,3,5,6},0));
    }
}