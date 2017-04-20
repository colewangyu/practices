package LeetCode.Easy;

import LeetCode.Easy._447_NumberOfBoomerangs;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class _447_NumberOfBoomerangsTest {
    _447_NumberOfBoomerangs t;

    @Before
    public void setUp() throws Exception {
        t = new _447_NumberOfBoomerangs();
    }

    @After
    public void tearDown() throws Exception {
        t = null;
    }

    @Test
    public void numberOfBoomerangs01() throws Exception {
        assertEquals(2, t.numberOfBoomerangs(new int[][]{{0, 0}, {0, 1}, {0, 2}}));
    }

}