package LeetCode.Medium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class _55_JumpGameTest {
    _55_JumpGame t;

    @Before
    public void setUp() throws Exception {
        t = new _55_JumpGame();
    }

    @After
    public void tearDown() throws Exception {
        t = null;
    }

    @Test
    public void canJump() throws Exception {
        assertTrue(t.canJump(new int[]{2,3,1,1,4}));
    }

    @Test
    public void cannotJump() throws Exception {
        assertTrue(t.canJump(new int[]{2,2,1,0,4}));
    }

}