package LeetCode.Medium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class _60_PermutationSequenceTest {
    _60_PermutationSequence t;

    @Before
    public void setUp() throws Exception {
        t = new _60_PermutationSequence();
    }

    @After
    public void tearDown() throws Exception {
        t = null;
    }

    @Test
    public void getPermutation() throws Exception {
        assertEquals("213", t.getPermutation(3, 3));
    }

    @Test
    public void getPermutationLeftBoundery() throws Exception {
        assertEquals("1", t.getPermutation(1, 1));
    }

    @Test
    public void getPermutationRightBoundery() throws Exception {
        assertEquals("321", t.getPermutation(3, 6));
    }

}