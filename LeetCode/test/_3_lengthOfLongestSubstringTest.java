import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

/**
 * Created by cole on 2016-05-10 Tuesday.
 */
public class _3_lengthOfLongestSubstringTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testLengthOfLongestSubstring() throws Exception {
        _3_lengthOfLongestSubstring t = new _3_lengthOfLongestSubstring();
        assertEquals(t.lengthOfLongestSubstring("abcabcbb"),3);
        assertEquals(t.lengthOfLongestSubstring("bbbbb"),1);
        assertEquals(t.lengthOfLongestSubstring("abcdefg"),7);
        assertEquals(t.lengthOfLongestSubstring("a"),1);
        assertEquals(t.lengthOfLongestSubstring("dvdf"),3);
        assertEquals(t.lengthOfLongestSubstring("abcddefg"),4);
        assertEquals(t.lengthOfLongestSubstring("abba"),2);

//        expectedEx.expect(NullPointerException.class);
    }
}