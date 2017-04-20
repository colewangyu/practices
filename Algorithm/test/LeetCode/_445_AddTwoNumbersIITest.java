package LeetCode;

import LeetCode.Medium._445_AddTwoNumbersII;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import LeetCode.Medium._445_AddTwoNumbersII.ListNode;

import static org.junit.Assert.*;

public class _445_AddTwoNumbersIITest {
    _445_AddTwoNumbersII t;

    @Before
    public void setUp() throws Exception {
        t = new _445_AddTwoNumbersII();
    }

    @After
    public void tearDown() throws Exception {
        t = null;
    }

    @Test
    public void addTwoNumbers01() throws Exception {
        ListNode l1 = new ListNode(7);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(4);
        ListNode l4 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;

        ListNode la = new ListNode(5);
        ListNode lb = new ListNode(6);
        ListNode lc = new ListNode(4);
        la.next = lb;
        lb.next = lc;

        ListNode result;
        result = t.addTwoNumbers(l1,la);
        assertEquals(7, result.val);
        result = result.next;
        assertEquals(8, result.val);
        result = result.next;
        assertEquals(0, result.val);
        result = result.next;
        assertEquals(7, result.val);
        result = result.next;
        assertNull(result);
    }

    @Test
    public void addTwoNumbers02() throws Exception {
        ListNode l1 = new ListNode(7);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;

        ListNode la = new ListNode(5);
        ListNode lb = new ListNode(6);
        ListNode lc = new ListNode(4);
        la.next = lb;
        lb.next = lc;

        ListNode result;
        result = t.addTwoNumbers(l1,la);
        assertEquals(1, result.val);
        result = result.next;
        assertEquals(2, result.val);
        result = result.next;
        assertEquals(8, result.val);
        result = result.next;
        assertEquals(8, result.val);
        result = result.next;
        assertNull(result);
    }

    @Test
    public void addTwoNumbers03() throws Exception {
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;

        ListNode la = new ListNode(5);
        ListNode lb = new ListNode(6);
        ListNode lc = new ListNode(4);
        la.next = lb;
        lb.next = lc;

        ListNode result;
        result = t.addTwoNumbers(l1,la);
        assertEquals(7, result.val);
        result = result.next;
        assertEquals(8, result.val);
        result = result.next;
        assertEquals(8, result.val);
        result = result.next;
        assertNull(result);
    }

    @Test
    public void addTwoNumbers04() throws Exception {
        ListNode l1 = new ListNode(9);
        ListNode l2 = new ListNode(9);
        l1.next = l2;

        ListNode la = new ListNode(1);

        ListNode result;
        result = t.addTwoNumbers(l1,la);
        assertEquals(1, result.val);
        result = result.next;
        assertEquals(0, result.val);
        result = result.next;
        assertEquals(0, result.val);
        result = result.next;
        assertNull(result);
    }

    @Test
    public void addTwoNumbers05() throws Exception {
        ListNode l1 = new ListNode(9);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(6);
        l1.next = l2;
        l2.next = l3;

        ListNode la = new ListNode(0);

        ListNode result;
        result = t.addTwoNumbers(l1,la);
        assertEquals(9, result.val);
        result = result.next;
        assertEquals(1, result.val);
        result = result.next;
        assertEquals(6, result.val);
        result = result.next;
        assertNull(result);
    }

}