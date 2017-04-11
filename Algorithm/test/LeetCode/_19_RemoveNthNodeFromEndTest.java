package LeetCode;

import LeetCode.Medium._19_RemoveNthNodeFromEnd;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static LeetCode.Medium._19_RemoveNthNodeFromEnd.*;

/**
 * Created by cole on 2016-11-24.
 */
public class _19_RemoveNthNodeFromEndTest {
    _19_RemoveNthNodeFromEnd t;

    @Before
    public void setUp() throws Exception {
        t = new _19_RemoveNthNodeFromEnd();
    }

    @After
    public void tearDown() throws Exception {
        t = null;
    }

    @Test
    public void removeNthFromEnd1() throws Exception {
        ListNode n1 = new ListNode(1);
        assertNull(t.removeNthFromEnd(n1,1));
    }

    @Test
    public void removeNthFromEnd2() throws Exception {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        n1.next = n2;
        ListNode assertNode = t.removeNthFromEnd(n1,1);
        assertEquals(n1, assertNode);
        assertEquals(null, assertNode.next);
    }

    @Test
    public void removeNthFromEnd3() throws Exception {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        ListNode assertNode = t.removeNthFromEnd(n1,2);
        assertEquals(n1, assertNode);
        assertEquals(n3, n1.next);
    }

    @Test
    public void removeNthFromEnd4() throws Exception {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        ListNode assertNode = t.removeNthFromEnd(n1, 2);
        assertEquals(n1, assertNode);
        assertEquals(n2, n1.next);
        assertEquals(n4, n2.next);
    }

}