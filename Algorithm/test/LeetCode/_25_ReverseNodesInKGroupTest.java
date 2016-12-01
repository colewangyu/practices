package LeetCode;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static LeetCode._25_ReverseNodesInKGroup.ListNode;

/**
 * Created by wy on 2016-12-01.
 */
public class _25_ReverseNodesInKGroupTest {
    _25_ReverseNodesInKGroup t;

    @Before
    public void setUp() throws Exception {
        t = new _25_ReverseNodesInKGroup();
    }

    @After
    public void tearDown() throws Exception {
        t = null;
    }

    @Test
    public void testReverseKGroup1() throws Exception {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        ListNode result = t.reverseKGroup(n1, 3);
        assertEquals(n3,result);
        result = result.next;
        assertEquals(n2,result);
        result = result.next;
        assertEquals(n1,result);
        result = result.next;
        assertEquals(n4,result);
    }

    @Test
    public void testReverseKGroup2() throws Exception {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);

        n1.next = n2;
        n2.next = n3;

        ListNode result = t.reverseKGroup(n1, 3);
        assertEquals(n3,result);
        result = result.next;
        assertEquals(n2,result);
        result = result.next;
        assertEquals(n1,result);

    }

    @Test
    public void testReverseKGroup3() throws Exception {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        ListNode result = t.reverseKGroup(n1, 5);
        assertEquals(n1,result);
        result = result.next;
        assertEquals(n2,result);
        result = result.next;
        assertEquals(n3,result);
        result = result.next;
        assertEquals(n4,result);
    }

    @Test
    public void testReverseKGroup4() throws Exception {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        ListNode result = t.reverseKGroup(n1, 2);
        assertEquals(n2,result);
        result = result.next;
        assertEquals(n1,result);
        result = result.next;
        assertEquals(n4,result);
        result = result.next;
        assertEquals(n3,result);
    }
}