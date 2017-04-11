package LeetCode;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class _47_PermutationsIITest {
    _47_PermutationsII t;

    @Before
    public void setUp() throws Exception {
        t = new _47_PermutationsII();
    }

    @After
    public void tearDown() throws Exception {
        t = null;
    }

    @Test
    public void permuteUnique01() throws Exception {
        List<List<Integer>> result = t.permuteUnique(new int[]{1,1,2});
        assertEquals(3, result.size());
    }

    @Test
    public void permuteUnique02() throws Exception {
        List<List<Integer>> result = t.permuteUnique(new int[]{1,1,1});
        assertEquals(1, result.size());
    }

    @Test
    public void permuteUnique03() throws Exception {
        List<List<Integer>> result = t.permuteUnique(new int[]{2,2,1,1});
        assertEquals(6, result.size());
    }

}