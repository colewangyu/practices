package LeetCode;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static LeetCode._24_SwapNodesInPairs.ListNode;

/**
 * Created by wy on 2016-12-01.
 */
public class _24_SwapNodesInPairsTest {
    _24_SwapNodesInPairs t;

    @Before
    public void setUp() throws Exception {
        t = new _24_SwapNodesInPairs();
    }

    @After
    public void tearDown() throws Exception {
        t = null;
    }

    @Test
    public void testSwapPairs1() throws Exception {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        ListNode result = t.swapPairs(n1);
        assertEquals(n2,result);
        assertEquals(n1,result.next);
        assertEquals(n3,result.next.next);
    }

    @Test
    public void testSwapPairs2() throws Exception {
        ListNode n1 = new ListNode(1);
        assertEquals(n1,t.swapPairs(n1));
    }

    @Test
    public void testSwapPairs3() throws Exception {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        ListNode result = t.swapPairs(n1);
        assertEquals(n2,result);
        result = result.next;
        assertEquals(n1,result);
        result = result.next;
        assertEquals(n4,result);
        result = result.next;
        assertEquals(n3,result);
    }
}