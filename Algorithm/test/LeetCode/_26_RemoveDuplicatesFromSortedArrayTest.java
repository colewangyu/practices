package LeetCode;

import LeetCode.Easy._26_RemoveDuplicatesFromSortedArray;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by cole on 2016-12-03.
 */
public class _26_RemoveDuplicatesFromSortedArrayTest {
    _26_RemoveDuplicatesFromSortedArray t;

    @Before
    public void setUp() throws Exception {
        t = new _26_RemoveDuplicatesFromSortedArray();
    }

    @After
    public void tearDown() throws Exception {
        t = null;
    }

    @Test
    public void removeDuplicates1() throws Exception {
        assertEquals(1, t.removeDuplicates(new int[]{1}));
    }

    @Test
    public void removeDuplicates2() throws Exception {
        assertEquals(2, t.removeDuplicates(new int[]{1,1,2}));
    }

    @Test
    public void removeDuplicates3() throws Exception {
        assertEquals(3, t.removeDuplicates(new int[]{1,2,2,3}));
    }

    @Test
    public void removeDuplicates4() throws Exception {
        assertEquals(0, t.removeDuplicates(new int[]{}));
    }

}