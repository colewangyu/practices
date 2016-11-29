import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by cole on 2016-11-27.
 */
public class OneExchange2SortedTest {
    OneExchange2Sorted t;
    
    @Before
    public void setUp() throws Exception {
        t = new OneExchange2Sorted();
    }

    @After
    public void tearDown() throws Exception {
        t = null;
    }

    @Test
    public void testOneExchange2Sorted1() throws Exception {
        assertTrue(t.oneExchange2Sorted(new int[]{1,5,3,4,3}));
    }

    @Test
    public void testOneExchange2Sorted2() throws Exception {
        assertTrue(t.oneExchange2Sorted(new int[]{1,5,3}));
    }

    @Test
    public void testOneExchange2Sorted3() throws Exception {
        assertFalse(t.oneExchange2Sorted(new int[]{5,3,4,3,4}));
    }

    @Test
    public void testOneExchange2Sorted4() throws Exception {
        assertTrue(t.oneExchange2Sorted(new int[]{1,5,3,3}));
    }

    @Test
    public void testOneExchange2Sorted5() throws Exception {
        assertTrue(t.oneExchange2Sorted(new int[]{5,3}));
    }

    @Test
    public void testOneExchange2Sorted6() throws Exception {
        assertTrue(t.oneExchange2Sorted(new int[]{1,5,3,6}));
    }
    @Test
    public void testOneExchange2Sorted7() throws Exception {
        assertFalse(t.oneExchange2Sorted(new int[]{5,3,5,4}));
    }

    @Test
    public void testOneExchange2Sorted8() throws Exception {
        assertTrue(t.oneExchange2Sorted(new int[]{5,3,5,5}));
    }

    @Test
    public void testOneExchange2Sorted9() throws Exception {
        assertFalse(t.oneExchange2Sorted(new int[]{5,3,5,4,5}));
    }

    @Test
    public void testOneExchange2Sorted10() throws Exception {
        assertFalse(t.oneExchange2Sorted(new int[]{5,3,5,4,6}));
    }

    @Test
    public void testOneExchange2Sorted11() throws Exception {
        assertTrue(t.oneExchange2Sorted(new int[]{5,3,5,3}));
    }

    @Test
    public void testOneExchange2Sorted12() throws Exception {
        assertTrue(t.oneExchange2Sorted(new int[]{5,3,5,3,5}));
    }

    @Test
    public void testOneExchange2Sorted13() throws Exception {
        assertTrue(t.oneExchange2Sorted(new int[]{5,3,5,2}));
    }

    @Test
    public void testOneExchange2Sorted14() throws Exception {
        assertFalse(t.oneExchange2Sorted(new int[]{5,3,5,2,4}));
    }

}