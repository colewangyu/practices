package LeetCode;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class _49_GroupAnagramsTest {
    _49_GroupAnagrams t;

    @Before
    public void setUp() throws Exception {
        t = new _49_GroupAnagrams();
    }

    @After
    public void tearDown() throws Exception {
        t = null;
    }

    @Test
    public void groupAnagrams() throws Exception {
        List<List<String>> result;
        result = t.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        List<List<String>> expect;
        expect = new ArrayList<List<String>>();
        List<String> tmp;
        tmp = new ArrayList<String>();
        tmp.add("bat");
        expect.add(tmp);
        tmp = new ArrayList<String>();
        tmp.add("eat");
        tmp.add("tea");
        tmp.add("ate");
        expect.add(tmp);
        tmp = new ArrayList<String>();
        tmp.add("tan");
        tmp.add("nat");
        expect.add(tmp);
        assertEquals(expect,result);
    }

}