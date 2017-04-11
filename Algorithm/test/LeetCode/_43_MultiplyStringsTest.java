package LeetCode;

import LeetCode.Medium._43_MultiplyStrings;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class _43_MultiplyStringsTest {
    _43_MultiplyStrings t;

    @Before
    public void setUp() throws Exception {
        t = new _43_MultiplyStrings();
    }

    @After
    public void tearDown() throws Exception {
        t = null;
    }

    @Test
    public void multiply01() throws Exception {
        assertEquals("1", t.multiply("1","1"));
    }

    @Test
    public void multiply02() throws Exception {
        assertEquals("9801", t.multiply("99","99"));
    }

    @Test
    public void multiply03() throws Exception {
        assertEquals("9999", t.multiply("9999","1"));
    }

    @Test
    public void multiply04() throws Exception {
        assertEquals("0", t.multiply("9999","0"));
    }

}