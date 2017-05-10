package LeetCode.Hard;

import LeetCode.Hard._76_MinimumWindowSubstring;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class _76_MinimumWindowSubstringTest {
    _76_MinimumWindowSubstring t;

    @Before
    public void setUp() throws Exception {
        t = new _76_MinimumWindowSubstring();
    }

    @After
    public void tearDown() throws Exception {
        t = null;
    }

    @Test
    public void TypeOfABC() throws Exception {
        assertEquals("BANC",t.minWindow("ADOBECODEBANC","ABC"));
    }

    @Test
    public void TypeOfABBC() throws Exception {
        assertEquals("BAABC",t.minWindow("ADOBECODEBAABC","ABBC"));
    }

    @Test
    public void TypeOfAAA() throws Exception {
        assertEquals("ABAA",t.minWindow("ADOBECODEABAAC","AAA"));
    }

    @Test
    public void TypeOfEquals() throws Exception {
        assertEquals("ABC",t.minWindow("ABC","ABC"));
    }

    @Test
    public void TypeOfAAInAAA() throws Exception {
        assertEquals("AA",t.minWindow("AAA","AA"));
    }

    @Test
    public void TypeOfAInB() throws Exception {
        assertEquals("",t.minWindow("B","A"));
    }

    @Test
    public void TypeOfABInBB() throws Exception {
        assertEquals("",t.minWindow("BB","AB"));
    }

    @Test
    public void TypeOf() throws Exception {
        assertEquals("cwae",t.minWindow("cabwefgewcwaefgcf","cwae"));
    }

    @Test
    public void TypeOfAAAInA() throws Exception {
        assertEquals("",t.minWindow("A","AAA"));
    }

    @Test
    public void ZeroLengthofS() throws Exception {
        assertEquals("",t.minWindow("","A"));
    }

    @Test
    public void ZeroLengthosT() throws Exception {
        assertEquals("",t.minWindow("A",""));
    }

    @Test
    public void NullofT() throws Exception {
        assertEquals("",t.minWindow("A",null));
    }

    @Test
    public void NullofS() throws Exception {
        assertEquals("",t.minWindow(null,"s"));
    }

}