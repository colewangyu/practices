package LeetCode.Easy;

import LeetCode.Easy._13_Roman2Integer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by cole on 2016-11-05.
 */
public class _13_Roman2IntegerTest {
    _13_Roman2Integer t;
    
    @Before
    public void setUp() throws Exception {
        t = new _13_Roman2Integer();
    }

    @After
    public void tearDown() throws Exception {
        t = null;
    }

    @Test
    public void testRomanToInt1() throws Exception {
        assertEquals(1, t.romanToInt("I"));
    }
    @Test
    public void testRomanToInt2() throws Exception {
        assertEquals(5, t.romanToInt("V"));
    }
    @Test
    public void testRomanToInt3() throws Exception {
        assertEquals(10, t.romanToInt("X"));
    }
    @Test
    public void testRomanToInt4() throws Exception {
        assertEquals(50, t.romanToInt("L"));
    }
    @Test
    public void testRomanToInt5() throws Exception {
        assertEquals(100, t.romanToInt("C"));
    }
    @Test
    public void testRomanToInt6() throws Exception {
        assertEquals(500, t.romanToInt("D"));
    }
    @Test
    public void testRomanToInt7() throws Exception {
        assertEquals(1000, t.romanToInt("M"));
    }
    @Test
    public void testRomanToInt8() throws Exception {
        assertEquals(2, t.romanToInt("II"));
    }
    @Test
    public void testRomanToInt9() throws Exception {
        assertEquals(4, t.romanToInt("IV"));
    }
    @Test
    public void testRomanToInt10() throws Exception {
        assertEquals(6, t.romanToInt("VI"));
    }
    @Test
    public void testRomanToInt11() throws Exception {
        assertEquals(60, t.romanToInt("LX"));
    }
    @Test
    public void testRomanToInt12() throws Exception {
        assertEquals(40, t.romanToInt("XL"));
    }
    @Test
    public void testRomanToInt13() throws Exception {
        assertEquals(400, t.romanToInt("CD"));
    }
    @Test
    public void testRomanToInt14() throws Exception {
        assertEquals(600, t.romanToInt("DC"));
    }
    @Test
    public void testRomanToInt15() throws Exception {
        assertEquals(1500, t.romanToInt("MD"));
    }
    @Test
    public void testRomanToInt16() throws Exception {
        assertEquals(3, t.romanToInt("III"));
    }
    @Test
    public void testRomanToInt17() throws Exception {
        assertEquals(30, t.romanToInt("XXX"));
    }
    @Test
    public void testRomanToInt18() throws Exception {
        assertEquals(300, t.romanToInt("CCC"));
    }
    @Test
    public void testRomanToInt19() throws Exception {
        assertEquals(3000, t.romanToInt("MMM"));
    }
    @Test
    public void testRomanToInt20() throws Exception {
        assertEquals(7, t.romanToInt("VII"));
    }
    @Test
    public void testRomanToInt21() throws Exception {
        assertEquals(70, t.romanToInt("LXX"));
    }
    @Test
    public void testRomanToInt22() throws Exception {
        assertEquals(700, t.romanToInt("DCC"));
    }
    @Test
    public void testRomanToInt23() throws Exception {
        assertEquals(16, t.romanToInt("XVI"));
    }
    @Test
    public void testRomanToInt24() throws Exception {
        assertEquals(14, t.romanToInt("XIV"));
    }
    @Test
    public void testRomanToInt25() throws Exception {
        assertEquals(650, t.romanToInt("DCL"));
    }
    @Test
    public void testRomanToInt26() throws Exception {
        assertEquals(450, t.romanToInt("CDL"));
    }
    @Test
    public void testRomanToInt27() throws Exception {
        assertEquals(1600, t.romanToInt("MDC"));
    }
    @Test
    public void testRomanToInt28() throws Exception {
        assertEquals(1400, t.romanToInt("MCD"));
    }
    @Test
    public void testRomanToInt29() throws Exception {
        assertEquals(8, t.romanToInt("VIII"));
    }
    @Test
    public void testRomanToInt30() throws Exception {
        assertEquals(80, t.romanToInt("LXXX"));
    }
    @Test
    public void testRomanToInt31() throws Exception {
        assertEquals(800, t.romanToInt("DCCC"));
    }
    @Test
    public void testRomanToInt32() throws Exception {
        assertEquals(1300, t.romanToInt("MCCC"));
    }
    @Test
    public void testRomanToInt33() throws Exception {
        assertEquals(17, t.romanToInt("XVII"));
    }
    @Test
    public void testRomanToInt34() throws Exception {
        assertEquals(750, t.romanToInt("DCCL"));
    }
    @Test
    public void testRomanToInt35() throws Exception {
        assertEquals(1700, t.romanToInt("MDCC"));
    }
    @Test
    public void testRomanToInt36() throws Exception {
        assertEquals(66, t.romanToInt("LXVI"));
    }
    @Test
    public void testRomanToInt37() throws Exception {
        assertEquals(64, t.romanToInt("LXIV"));
    }
    @Test
    public void testRomanToInt38() throws Exception {
        assertEquals(1650, t.romanToInt("MDCL"));
    }
    @Test
    public void testRomanToInt39() throws Exception {
        assertEquals(1450, t.romanToInt("MCDL"));
    }
    @Test
    public void testRomanToInt40() throws Exception {
        assertEquals(230, t.romanToInt("CCXXX"));
    }
    @Test
    public void testRomanToInt41() throws Exception {
        assertEquals(2300, t.romanToInt("MMCCC"));
    }
    @Test
    public void testRomanToInt42() throws Exception {
        assertEquals(18, t.romanToInt("XVIII"));
    }
    @Test
    public void testRomanToInt43() throws Exception {
        assertEquals(180, t.romanToInt("CLXXX"));
    }
    @Test
    public void testRomanToInt44() throws Exception {
        assertEquals(1800, t.romanToInt("MDCCC"));
    }
    @Test
    public void testRomanToInt45() throws Exception {
        assertEquals(67, t.romanToInt("LXVII"));
    }
    @Test
    public void testRomanToInt46() throws Exception {
        assertEquals(1660, t.romanToInt("MDCLX"));
    }
    @Test
    public void testRomanToInt47() throws Exception {
        assertEquals(666, t.romanToInt("DCLXVI"));
    }
    @Test
    public void testRomanToInt48() throws Exception {
        assertEquals(1665, t.romanToInt("MDCLXV"));
    }
    @Test
    public void testRomanToInt49() throws Exception {
        assertEquals(1666, t.romanToInt("MDCLXVI"));
    }
    @Test
    public void testRomanToInt50() throws Exception {
        assertEquals(3999, t.romanToInt("MMMCMXCIX"));
    }
    @Test
    public void testRomanToInt51() throws Exception {
        assertEquals(0, t.romanToInt(""));
    }
    @Test
    public void testRomanToInt52() throws Exception {
        assertEquals(0, t.romanToInt("IIII"));
    }
    @Test
    public void testRomanToInt53() throws Exception {
        assertEquals(0, t.romanToInt("IIV"));
    }
    @Test
    public void testRomanToInt54() throws Exception {
        assertEquals(0, t.romanToInt("IC"));
    }
    @Test
    public void testRomanToInt55() throws Exception {
        assertEquals(0, t.romanToInt("XM"));
    }
    @Test
    public void testRomanToInt56() throws Exception {
        assertEquals(0, t.romanToInt("VL"));
    }
    @Test
    public void testRomanToInt57() throws Exception {
        assertEquals(0, t.romanToInt("LD"));
    }
    @Test
    public void testRomanToInt58() throws Exception {
        assertEquals(0, t.romanToInt("DM"));
    }

}