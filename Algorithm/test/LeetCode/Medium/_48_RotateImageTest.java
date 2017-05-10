package LeetCode.Medium;

import LeetCode.Medium._48_RotateImage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class _48_RotateImageTest {
    _48_RotateImage t;

    @Before
    public void setUp() throws Exception {
        t = new _48_RotateImage();
    }

    @After
    public void tearDown() throws Exception {
        t = null;
    }

    @Test
    public void rotate() throws Exception {
        int[][] matrix = new int[][]{{1,2},{3,4}};
        t.rotate(matrix);
        assertEquals(new int[][]{{3,1},{4,2}}, matrix);
    }

}