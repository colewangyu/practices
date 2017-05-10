package LeetCode.Medium;

import LeetCode.Medium._54_SpiralMatrix;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class _54_SpiralMatrixTest {
    _54_SpiralMatrix t;

    @Before
    public void setUp() throws Exception {
        t = new _54_SpiralMatrix();
    }

    @After
    public void tearDown() throws Exception {
        t = null;
    }

    @Test
    public void spiralOrder01() throws Exception {
        List<Integer> result;
        result = t.spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        assertArrayEquals(new Object[]{1, 2, 3, 6, 9, 8, 7, 4, 5}, result.toArray());
    }

    @Test
    public void spiralOrder02() throws Exception {
        List<Integer> result;
        result = t.spiralOrder(new int[][]{{1}, {4}, {7}});
        assertArrayEquals(new Object[]{1, 4, 7}, result.toArray());
    }

    @Test
    public void spiralOrder03() throws Exception {
        List<Integer> result;
        result = t.spiralOrder(new int[][]{{1, 2, 3}});
        assertArrayEquals(new Object[]{1, 2, 3}, result.toArray());
    }

    @Test
    public void spiralOrder04() throws Exception {
        List<Integer> result;
        result = t.spiralOrder(new int[][]{{}});
        assertArrayEquals(new Object[]{}, result.toArray());
    }

}