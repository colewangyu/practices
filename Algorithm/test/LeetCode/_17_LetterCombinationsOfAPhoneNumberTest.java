package LeetCode;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wy on 2016-11-22.
 */
public class _17_LetterCombinationsOfAPhoneNumberTest {
    _17_LetterCombinationsOfAPhoneNumber t;

    @Before
    public void setUp() throws Exception {
        t = new _17_LetterCombinationsOfAPhoneNumber();
    }

    @After
    public void tearDown() throws Exception {
        t = null;
    }

    @Test
    public void testLetterCombinations1() throws Exception {
        List<String> expected = new ArrayList<String>();
        expected.add("a");
        expected.add("b");
        expected.add("c");
        assertEquals(expected, t.letterCombinations("2"));
    }

    @Test
    public void testLetterCombinations2() throws Exception {
        List<String> expected = new ArrayList<String>();
        expected.add("ad");
        expected.add("ae");
        expected.add("af");
        expected.add("bd");
        expected.add("be");
        expected.add("bf");
        expected.add("cd");
        expected.add("ce");
        expected.add("cf");
        assertEquals(expected, t.letterCombinations("23"));
    }

    @Test
    public void testLetterCombinations3() throws Exception {
        assertEquals(new ArrayList<String>(), t.letterCombinations(""));
    }
}