package LeetCode.Medium;

import LeetCode.Medium._12_Integer2Roman;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by cole on 2016-11-05.
 */
public class _12_Integer2RomanTest {
    _12_Integer2Roman t;

    @Before
    public void setUp() throws Exception {
        t = new _12_Integer2Roman();
    }

    @After
    public void tearDown() throws Exception {
        t = null;
    }

    /*
    I（1）、V（5）、X（10）、L（50）、C（100）、D（500）、M（1000）
    有效输入:
    1. 单一罗马字母
    2. 两个罗马字母
    3. 三个罗马字母
    4. 四个罗马字母
    5. 五个罗马字母
    6. 六个罗马字母
    7. 七个罗马字母
    无效输入:
    1. 0
    2. 负数
     */
    @Test
    public void testIntToRoman1() throws Exception {
        assertEquals("I", t.intToRoman(1));
    }
    @Test
    public void testIntToRoman2() throws Exception {
        assertEquals("V", t.intToRoman(5));
    }
    @Test
    public void testIntToRoman3() throws Exception {
        assertEquals("X", t.intToRoman(10));
    }
    @Test
    public void testIntToRoman4() throws Exception {
        assertEquals("L", t.intToRoman(50));
    }
    @Test
    public void testIntToRoman5() throws Exception {
        assertEquals("C", t.intToRoman(100));
    }
    @Test
    public void testIntToRoman6() throws Exception {
        assertEquals("D", t.intToRoman(500));
    }
    @Test
    public void testIntToRoman7() throws Exception {
        assertEquals("M", t.intToRoman(1000));
    }
    @Test
    public void testIntToRoman8() throws Exception {
        assertEquals("II", t.intToRoman(2));
    }
    @Test
    public void testIntToRoman9() throws Exception {
        assertEquals("IV", t.intToRoman(4));
    }
    @Test
    public void testIntToRoman10() throws Exception {
        assertEquals("VI", t.intToRoman(6));
    }
    @Test
    public void testIntToRoman11() throws Exception {
        assertEquals("LX", t.intToRoman(60));
    }
    @Test
    public void testIntToRoman12() throws Exception {
        assertEquals("XL", t.intToRoman(40));
    }
    @Test
    public void testIntToRoman13() throws Exception {
        assertEquals("CD", t.intToRoman(400));
    }
    @Test
    public void testIntToRoman14() throws Exception {
        assertEquals("DC", t.intToRoman(600));
    }
    @Test
    public void testIntToRoman15() throws Exception {
        assertEquals("MD", t.intToRoman(1500));
    }
    @Test
    public void testIntToRoman16() throws Exception {
        assertEquals("III", t.intToRoman(3));
    }
    @Test
    public void testIntToRoman17() throws Exception {
        assertEquals("XXX", t.intToRoman(30));
    }
    @Test
    public void testIntToRoman18() throws Exception {
        assertEquals("CCC", t.intToRoman(300));
    }
    @Test
    public void testIntToRoman19() throws Exception {
        assertEquals("MMM", t.intToRoman(3000));
    }
    @Test
    public void testIntToRoman20() throws Exception {
        assertEquals("VII", t.intToRoman(7));
    }
    @Test
    public void testIntToRoman21() throws Exception {
        assertEquals("LXX", t.intToRoman(70));
    }
    @Test
    public void testIntToRoman22() throws Exception {
        assertEquals("DCC", t.intToRoman(700));
    }
    @Test
    public void testIntToRoman23() throws Exception {
        assertEquals("XVI", t.intToRoman(16));
    }
    @Test
    public void testIntToRoman24() throws Exception {
        assertEquals("XIV", t.intToRoman(14));
    }
    @Test
    public void testIntToRoman25() throws Exception {
        assertEquals("DCL", t.intToRoman(650));
    }
    @Test
    public void testIntToRoman26() throws Exception {
        assertEquals("CDL", t.intToRoman(450));
    }
    @Test
    public void testIntToRoman27() throws Exception {
        assertEquals("MDC", t.intToRoman(1600));
    }
    @Test
    public void testIntToRoman28() throws Exception {
        assertEquals("MCD", t.intToRoman(1400));
    }
    @Test
    public void testIntToRoman29() throws Exception {
        assertEquals("VIII", t.intToRoman(8));
    }
    @Test
    public void testIntToRoman30() throws Exception {
        assertEquals("LXXX", t.intToRoman(80));
    }
    @Test
    public void testIntToRoman31() throws Exception {
        assertEquals("DCCC", t.intToRoman(800));
    }
    @Test
    public void testIntToRoman32() throws Exception {
        assertEquals("MCCC", t.intToRoman(1300));
    }
    @Test
    public void testIntToRoman33() throws Exception {
        assertEquals("XVII", t.intToRoman(17));
    }
    @Test
    public void testIntToRoman34() throws Exception {
        assertEquals("DCCL", t.intToRoman(750));
    }
    @Test
    public void testIntToRoman35() throws Exception {
        assertEquals("MDCC", t.intToRoman(1700));
    }
    @Test
    public void testIntToRoman36() throws Exception {
        assertEquals("LXVI", t.intToRoman(66));
    }
    @Test
    public void testIntToRoman37() throws Exception {
        assertEquals("LXIV", t.intToRoman(64));
    }
    @Test
    public void testIntToRoman38() throws Exception {
        assertEquals("MDCL", t.intToRoman(1650));
    }
    @Test
    public void testIntToRoman39() throws Exception {
        assertEquals("MCDL", t.intToRoman(1450));
    }
    @Test
    public void testIntToRoman40() throws Exception {
        assertEquals("CCXXX", t.intToRoman(230));
    }
    @Test
    public void testIntToRoman41() throws Exception {
        assertEquals("MMCCC", t.intToRoman(2300));
    }
    @Test
    public void testIntToRoman42() throws Exception {
        assertEquals("XVIII", t.intToRoman(18));
    }
    @Test
    public void testIntToRoman43() throws Exception {
        assertEquals("CLXXX", t.intToRoman(180));
    }
    @Test
    public void testIntToRoman44() throws Exception {
        assertEquals("MDCCC", t.intToRoman(1800));
    }
    @Test
    public void testIntToRoman45() throws Exception {
        assertEquals("LXVII", t.intToRoman(67));
    }
    @Test
    public void testIntToRoman46() throws Exception {
        assertEquals("MDCLX", t.intToRoman(1660));
    }
    @Test
    public void testIntToRoman47() throws Exception {
        assertEquals("DCLXVI", t.intToRoman(666));
    }
    @Test
    public void testIntToRoman48() throws Exception {
        assertEquals("MDCLXV", t.intToRoman(1665));
    }
    @Test
    public void testIntToRoman49() throws Exception {
        assertEquals("MDCLXVI", t.intToRoman(1666));
    }
    @Test
    public void testIntToRoman50() throws Exception {
        assertEquals("MMMCMXCI", t.intToRoman(3999));
    }
    @Test
    public void testIntToRoman51() throws Exception {
        assertEquals("", t.intToRoman(0));
    }
    @Test
    public void testIntToRoman52() throws Exception {
        assertEquals("", t.intToRoman(4000));
    }
}