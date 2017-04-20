package LeetCode;

import LeetCode.Easy._38_CountAndSay;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class _38_CountAndSayTest {
    _38_CountAndSay t;

    @Before
    public void setUp() throws Exception {
        t = new _38_CountAndSay();
    }

    @After
    public void tearDown() throws Exception {
        t = null;
    }

    @Test
    public void countAndSay1() throws Exception {
        assertEquals("1", t.countAndSay(1));
    }

    @Test
    public void countAndSay2() throws Exception {
        assertEquals("11", t.countAndSay(2));
    }

    @Test
    public void countAndSay3() throws Exception {
        assertEquals("21", t.countAndSay(3));
    }

    @Test
    public void countAndSay4() throws Exception {
        assertEquals("1211", t.countAndSay(4));
    }

    @Test
    public void countAndSay5() throws Exception {
        assertEquals("111221", t.countAndSay(5));
    }

    @Test
    public void countAndSay11() throws Exception {
        assertEquals("11131221133112132113212221", t.countAndSay(11));
    }

}