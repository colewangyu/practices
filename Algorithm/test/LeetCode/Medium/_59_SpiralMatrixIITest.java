package LeetCode.Medium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class _59_SpiralMatrixIITest {
    _59_SpiralMatrixII t;

    @Before
    public void setUp() throws Exception {
        t = new _59_SpiralMatrixII();
    }

    @After
    public void tearDown() throws Exception {
        t = null;
    }

    @Test
    public void generateMatrixLength0() throws Exception {
        int[][] expect;
        expect = new int[0][0];
        int[][] actual = t.generateMatrix(0);
        assertArrayEquals(expect, actual);
    }

    @Test
    public void generateMatrixLength1() throws Exception {
        int[][] expect;
        expect = new int[][]{{1}};
        int[][] actual = t.generateMatrix(1);
        assertArrayEquals(expect, actual);
    }

    @Test
    public void generateMatrixLength4() throws Exception {
        int[][] expect;
        expect = new int[][]{
                {1, 2, 3, 4},
                {12, 13, 14, 5},
                {11, 16, 15, 6},
                {10, 9, 8, 7}};
        int[][] actual = t.generateMatrix(4);
        assertArrayEquals(expect, actual);
    }

}