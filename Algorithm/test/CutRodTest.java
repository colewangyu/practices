import DynamicProgramming.CutRod;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

/**
 * Created by wy on 2016-06-01.
 */
public class CutRodTest {
    CutRod t;  //测试对象声明
    int[] p = {1,5,8,9,10,17,17,20,24,30};

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        t = new CutRod();
    }

    @Test
    public void testCutRodTopDown() throws Exception {
        assertEquals(0, t.cutRodTopDown(p, 0));
        assertEquals(1, t.cutRodTopDown(p, 1));
        assertEquals(5, t.cutRodTopDown(p, 2));
        assertEquals(10, t.cutRodTopDown(p, 4));
        assertEquals(17, t.cutRodTopDown(p, 6));
        assertEquals(18, t.cutRodTopDown(p, 7));
        assertEquals(30, t.cutRodTopDown(p, 10));

        thrown.expect(IllegalArgumentException.class);
        t.cutRodTopDown(p,-1);
        thrown.expect(IllegalArgumentException.class);
        t.cutRodTopDown(null,2);
        thrown.expect(IllegalArgumentException.class);
        t.cutRodTopDown(null,-1);
    }

    @Test
    public void testCutRodBottomUp() throws Exception {
        assertEquals(0, t.cutRodBottomUp(p, 0));
        assertEquals(1, t.cutRodBottomUp(p, 1));
        assertEquals(5, t.cutRodBottomUp(p, 2));
        assertEquals(10, t.cutRodBottomUp(p, 4));
        assertEquals(17, t.cutRodBottomUp(p, 6));
        assertEquals(18, t.cutRodBottomUp(p, 7));
        assertEquals(30, t.cutRodBottomUp(p, 10));

        thrown.expect(IllegalArgumentException.class);
        t.cutRodBottomUp(p,-1);
        thrown.expect(IllegalArgumentException.class);
        t.cutRodBottomUp(null,2);
        thrown.expect(IllegalArgumentException.class);
        t.cutRodBottomUp(null,-1);
    }
}