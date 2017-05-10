package LeetCode.Medium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class _62_UniquePathsTest {
    _62_UniquePaths t;

    @Before
    public void setUp() throws Exception {
        t = new _62_UniquePaths();
    }

    @After
    public void tearDown() throws Exception {
        t = null;
    }

    @Test
    public void testUniquePaths1x1() throws Exception {
        Assert.assertEquals(1, t.uniquePaths(1, 1));
    }

    @Test
    public void testUniquePaths2x2() throws Exception {
        Assert.assertEquals(2, t.uniquePaths(2, 2));
    }

    @Test
    public void testUniquePaths1x10() throws Exception {
        Assert.assertEquals(1, t.uniquePaths(1, 10));
    }

    @Test
    public void testUniquePaths10x1() throws Exception {
        Assert.assertEquals(1, t.uniquePaths(10, 1));
    }

    @Test
    public void testUniquePaths2x3() throws Exception {
        Assert.assertEquals(3, t.uniquePaths(2, 3));
    }

    @Test
    public void testUniquePaths3x2() throws Exception {
        Assert.assertEquals(3, t.uniquePaths(3, 2));
    }

    @Test
    public void testUniquePaths3x3() throws Exception {
        Assert.assertEquals(6, t.uniquePaths(3, 3));
    }

    @Test
    public void testUniquePaths23x12() throws Exception {
        Assert.assertEquals(193536720, t.uniquePaths(23, 12));
    }
}