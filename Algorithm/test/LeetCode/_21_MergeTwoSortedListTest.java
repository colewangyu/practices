package LeetCode;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static LeetCode._21_MergeTwoSortedList.*;

/**
 * Created by cole on 2016-11-24.
 */
public class _21_MergeTwoSortedListTest {
    _21_MergeTwoSortedList t;
    @Before
    public void setUp() throws Exception {
        t = new _21_MergeTwoSortedList();
    }

    @After
    public void tearDown() throws Exception {
        t = null;
    }

    @Test
    public void mergeTwoLists1() throws Exception {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode N1 = new ListNode(1);
        ListNode N2 = new ListNode(4);
        ListNode N3 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        N1.next = N2;
        N2.next = N3;
        ListNode assertNode = t.mergeTwoLists(n1,N1);
        assertEquals(1, assertNode.val);
        assertNode = assertNode.next;
        assertEquals(1, assertNode.val);
        assertNode = assertNode.next;
        assertEquals(2, assertNode.val);
        assertNode = assertNode.next;
        assertEquals(3, assertNode.val);
        assertNode = assertNode.next;
        assertEquals(4, assertNode.val);
        assertNode = assertNode.next;
        assertEquals(5, assertNode.val);
    }

    @Test
    public void mergeTwoLists2() throws Exception {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(7);
        ListNode N1 = new ListNode(2);
        ListNode N2 = new ListNode(3);
        ListNode N3 = new ListNode(4);
        ListNode N4 = new ListNode(5);
        n1.next = n2;
        N1.next = N2;
        N2.next = N3;
        N3.next = N4;
        ListNode assertNode = t.mergeTwoLists(n1,N1);
        assertEquals(1, assertNode.val);
        assertNode = assertNode.next;
        assertEquals(2, assertNode.val);
        assertNode = assertNode.next;
        assertEquals(3, assertNode.val);
        assertNode = assertNode.next;
        assertEquals(4, assertNode.val);
        assertNode = assertNode.next;
        assertEquals(5, assertNode.val);
        assertNode = assertNode.next;
        assertEquals(7, assertNode.val);
    }

    @Test
    public void mergeTwoLists3() throws Exception {
        ListNode n1 = new ListNode(4);
        ListNode N1 = new ListNode(2);
        ListNode N2 = new ListNode(3);
        ListNode N3 = new ListNode(5);
        ListNode N4 = new ListNode(6);
        N1.next = N2;
        N2.next = N3;
        N3.next = N4;
        ListNode assertNode = t.mergeTwoLists(n1,N1);
        assertEquals(2, assertNode.val);
        assertNode = assertNode.next;
        assertEquals(3, assertNode.val);
        assertNode = assertNode.next;
        assertEquals(4, assertNode.val);
        assertNode = assertNode.next;
        assertEquals(5, assertNode.val);
        assertNode = assertNode.next;
        assertEquals(6, assertNode.val);
    }

    @Test
    public void mergeTwoLists4() throws Exception {
        ListNode n1 = null;
        ListNode N1 = new ListNode(2);
        ListNode N2 = new ListNode(3);
        ListNode N3 = new ListNode(5);
        ListNode N4 = new ListNode(6);
        N1.next = N2;
        N2.next = N3;
        N3.next = N4;
        ListNode assertNode = t.mergeTwoLists(n1,N1);
        assertEquals(2, assertNode.val);
        assertNode = assertNode.next;
        assertEquals(3, assertNode.val);
        assertNode = assertNode.next;
        assertEquals(5, assertNode.val);
        assertNode = assertNode.next;
        assertEquals(6, assertNode.val);
    }


}