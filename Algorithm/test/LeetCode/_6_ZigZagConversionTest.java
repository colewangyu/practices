package LeetCode;

import LeetCode.Medium._6_ZigZagConversion;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by cole on 2016-10-30.
 */
public class _6_ZigZagConversionTest {
    _6_ZigZagConversion t;

    @Before
    public void setUp() throws Exception {
        t = new _6_ZigZagConversion();
    }

    @After
    public void tearDown() throws Exception {
        t = null;
    }

    @Test
    public void convert1() throws Exception {
        assertEquals("PAHNAPLSIIGYIR", t.convert("PAYPALISHIRING", 3));
    }

    @Test
    public void convert2() throws Exception {
        assertEquals("PAYPALISHIRING", t.convert("PAYPALISHIRING", 1));
    }

    @Test
    public void convert3() throws Exception {
        assertEquals("P", t.convert("P", 3));
    }

    @Test
    public void convert4() throws Exception {
        assertEquals("PAY", t.convert("PAY", 3));
    }
}