package LeetCode.Medium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class _56_MergeIntervalsTest {
    _56_MergeIntervals t;

    @Before
    public void setUp() throws Exception {
        t = new _56_MergeIntervals();
    }

    @After
    public void tearDown() throws Exception {
        t = null;
    }

    private boolean equals(List<Interval> expect, List<Interval> actual) {
        if(expect.size() != actual.size())
            return false;
        for(int i = 0; i < expect.size(); i++ ) {
            if(expect.get(i).start != actual.get(i).start || expect.get(i).end != actual.get(i).end)
                return false;
        }
        return true;
    }

    @Test
    public void testMergeOnce() throws Exception {
        List<Interval> expect = new ArrayList<Interval>();
        expect.add(new Interval(1,6));
        expect.add(new Interval(8,10));
        expect.add(new Interval(13,15));
        List<Interval> param = new ArrayList<Interval>();
        param.add(new Interval(1,3));
        param.add(new Interval(2,6));
        param.add(new Interval(8,10));
        param.add(new Interval(13,15));
        assertTrue(equals(expect, t.merge(param)));
    }

    @Test
    public void testMergeTwice() throws Exception {
        List<Interval> expect = new ArrayList<Interval>();
        expect.add(new Interval(1,10));
        expect.add(new Interval(13,15));
        List<Interval> param = new ArrayList<Interval>();
        param.add(new Interval(1,3));
        param.add(new Interval(2,6));
        param.add(new Interval(6,10));
        param.add(new Interval(13,15));
        assertTrue(equals(expect, t.merge(param)));
    }

    @Test
    public void testMergeLeft() throws Exception {
        List<Interval> expect = new ArrayList<Interval>();
        expect.add(new Interval(0,4));
        List<Interval> param = new ArrayList<Interval>();
        param.add(new Interval(1,4));
        param.add(new Interval(0,4));
        assertTrue(equals(expect, t.merge(param)));
    }

    @Test
    public void testMergeContain() throws Exception {
        List<Interval> expect = new ArrayList<Interval>();
        expect.add(new Interval(0,5));
        List<Interval> param = new ArrayList<Interval>();
        param.add(new Interval(1,4));
        param.add(new Interval(0,5));
        assertTrue(equals(expect, t.merge(param)));
    }

    @Test
    public void testMergeNotSorted() throws Exception {
        List<Interval> expect = new ArrayList<Interval>();
        expect.add(new Interval(1,4));
        List<Interval> param = new ArrayList<Interval>();
        param.add(new Interval(1,2));
        param.add(new Interval(3,4));
        param.add(new Interval(2,3));
        assertTrue(equals(expect, t.merge(param)));
    }

    @Test
    public void testNoMerge() throws Exception {
        List<Interval> expect = new ArrayList<Interval>();
        expect.add(new Interval(1,3));
        expect.add(new Interval(13,15));
        List<Interval> param = new ArrayList<Interval>();
        param.add(new Interval(1,3));
        param.add(new Interval(13,15));
        assertTrue(equals(expect, t.merge(param)));
    }

    @Test
    public void testOnlyOneInterval() throws Exception {
        List<Interval> expect = new ArrayList<Interval>();
        expect.add(new Interval(1,6));
        List<Interval> param = new ArrayList<Interval>();
        param.add(new Interval(1,6));
        assertArrayEquals(expect.toArray(), t.merge(param).toArray());
    }

}