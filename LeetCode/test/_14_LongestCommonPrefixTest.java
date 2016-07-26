import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by cole on 2016-06-21.
 */
public class _14_LongestCommonPrefixTest {

    @Test
    public void testLongestCommonPrefix() throws Exception {
        _14_LongestCommonPrefix t = new _14_LongestCommonPrefix();
        assertEquals("", t.longestCommonPrefix(new String[]{"aba","abab",""}));
        assertEquals("a", t.longestCommonPrefix(new String[]{"aa","ab"}));
        assertEquals("a", t.longestCommonPrefix(new String[]{"aa","a"}));
        assertEquals("", t.longestCommonPrefix(new String[]{"aa","ba"}));
        assertEquals("Leet", t.longestCommonPrefix(new String[]{"Leet","Leets","LeetCode"}));
    }
}