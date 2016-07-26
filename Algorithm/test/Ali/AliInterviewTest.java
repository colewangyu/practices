package Ali;

import static org.junit.Assert.*;

/**
 * Created by wy on 2016-07-18.
 */
public class AliInterviewTest {

    @org.junit.Test
    public void testRecursionReverse() throws Exception {
        AliInterview t = new AliInterview();
        assertEquals("321",t.recursionReverse(123));
        assertEquals("0",t.recursionReverse(0));
        assertEquals("1",t.recursionReverse(1));
        assertEquals("21",t.recursionReverse(12));
        assertEquals("2101",t.recursionReverse(1012));
        assertEquals("0987654321",t.recursionReverse(1234567890));
    }
}