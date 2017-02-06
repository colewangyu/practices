package LeetCode;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by wy on 2017-02-06.
 */
public class _33_SearchInRotatedSortedArrayTest {
    _33_SearchInRotatedSortedArray t;

    @Before
    public void setUp() throws Exception {
        t = new _33_SearchInRotatedSortedArray();
    }

    @After
    public void tearDown() throws Exception {
        t = null;
    }

    @Test
    public void testSearch01() throws Exception {
        assertEquals(-1,t.search(new int[]{},5));
    }
    @Test
    public void testSearch02() throws Exception {
        assertEquals(5,t.search(new int[]{0,1,2,3,4,5},5));
    }
    @Test
    public void testSearch03() throws Exception {
        assertEquals(3,t.search(new int[]{0,1,2,3,4,5},3));
    }
    @Test
    public void testSearch04() throws Exception {
        assertEquals(0,t.search(new int[]{0,1,2,3,4,5},0));
    }

}