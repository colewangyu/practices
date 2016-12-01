package LeetCode;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static LeetCode._23_MergeKSortedLists.ListNode;
import static org.junit.Assert.*;


/**
 * Created by cole on 2016-11-30.
 */
public class _23_MergeKSortedListsTest {
    _23_MergeKSortedLists t;

    @Before
    public void setUp() throws Exception {
        t = new _23_MergeKSortedLists();
    }

    @After
    public void tearDown() throws Exception {
        t = null;
    }

    @Test
    public void mergeKLists1() throws Exception {
        ListNode n11 = new ListNode(1);
        ListNode n12 = new ListNode(2);
        ListNode n13 = new ListNode(3);
        ListNode n21 = new ListNode(1);
        ListNode n22 = new ListNode(5);
        ListNode n23 = new ListNode(6);
        ListNode n31 = new ListNode(0);
        ListNode n32 = new ListNode(4);
        ListNode n33 = new ListNode(9);
        n11.next = n12;
        n12.next = n13;
        n21.next = n22;
        n22.next = n23;
        n31.next = n32;
        n32.next = n33;
        ListNode[] lists = {n11,n21,n31};

        ListNode assertNode = t.mergeKLists(lists);
        assertEquals(0, assertNode.val);
        assertNode = assertNode.next;
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
        assertNode = assertNode.next;
        assertEquals(6, assertNode.val);
        assertNode = assertNode.next;
        assertEquals(9, assertNode.val);

    }

    @Test
    public void mergeKLists2() throws Exception {
        ListNode[] lists = {};
        assertNull(t.mergeKLists(lists));
    }

}