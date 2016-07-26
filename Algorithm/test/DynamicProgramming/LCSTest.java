package DynamicProgramming;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

/**
 * Created by wy on 2016-06-13.
 */
public class LCSTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testLCS() throws Exception {
        LCS t = new LCS();
        assertEquals(4, t.LCS(new char[]{'a','b','c','b','d','a','b'},new char[]{'b','d','c','a','b','a'}));
        assertEquals(0, t.LCS(new char[]{'a'},new char[]{'b'}));
        assertEquals(1, t.LCS(new char[]{'a'},new char[]{'a'}));
        thrown.expect(NullPointerException.class);
        t.LCS(null,null);
        t.LCS(null,new char[]{'a'});
        t.LCS(new char[]{'a'},null);
    }

    @Test
    public void testLCS_Recusion() throws Exception {
        LCS t = new LCS();
        assertEquals(4, t.LCS_Recusion(new char[]{'a','b','c','b','d','a','b'},new char[]{'b','d','c','a','b','a'}));
        assertEquals(0, t.LCS_Recusion(new char[]{'a'},new char[]{'b'}));
        assertEquals(1, t.LCS_Recusion(new char[]{'a'},new char[]{'a'}));
        thrown.expect(NullPointerException.class);
        t.LCS_Recusion(null,null);
        t.LCS_Recusion(null,new char[]{'a'});
        t.LCS_Recusion(new char[]{'a'},null);
    }

    @Test
    public void testGetLCS() throws Exception {
        LCS t = new LCS();
        assertEquals("bcba", t.getLCS(new char[]{'a','b','c','b','d','a','b'},new char[]{'b','d','c','a','b','a'}));
        assertEquals("", t.getLCS(new char[]{'a'},new char[]{'b'}));
        assertEquals("a", t.getLCS(new char[]{'a'},new char[]{'a'}));
        thrown.expect(NullPointerException.class);
        t.getLCS(null,null);
        t.getLCS(null,new char[]{'a'});
        t.getLCS(new char[]{'a'},null);
    }
}