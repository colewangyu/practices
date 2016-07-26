import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

/**
 * Created by wy on 2016-05-26.
 */
public class LongestPalindromeSubqueueTest {
    private LongestPalindromeSubqueue t;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setUp() {
        t = new LongestPalindromeSubqueue();
    }

    @Test
    public void testGetLengthofLPS() throws Exception {
        //有效等价类验证
        assertEquals(3, t.getLengthofLPS("abca"));
        assertEquals(4, t.getLengthofLPS("aaaca"));
        assertEquals(11, t.getLengthofLPS("abcbcaaaaababa"));

        //无效等价类验证
        thrown.expect(NullPointerException.class);
        t.getLengthofLPS(null);
    }

    @Test
    public void testGetLPS() throws Exception {
        //有效等价类验证
        assertEquals("aba", t.getLPS("abca"));
        assertEquals("aaaa", t.getLPS("aaaca"));
        assertEquals("abbaaaaabba", t.getLPS("abcbcaaaaababa"));

        //无效等价类验证
        thrown.expect(NullPointerException.class);
        t.getLengthofLPS(null);
    }

    @Test
    public void testGetDeleteLPS() throws Exception {
        //有效等价类验证
        assertEquals(2, t.getDeleteLPS("babca"));
        assertEquals(3, t.getDeleteLPS("baaacca"));
        assertEquals(1, t.getDeleteLPS("aaaba"));

        //无效等价类验证
        thrown.expect(NullPointerException.class);
        t.getLengthofLPS(null);
    }
}