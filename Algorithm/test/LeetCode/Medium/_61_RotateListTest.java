package LeetCode.Medium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import LeetCode.Medium._61_RotateList.ListNode;

public class _61_RotateListTest {
    _61_RotateList t;
    ListNode n1;
    ListNode n2;
    ListNode n3;
    ListNode n4;

    @Before
    public void setUp() throws Exception {
        t = new _61_RotateList();
        n1 = t.new ListNode(1);
        n2 = t.new ListNode(2);
        n3 = t.new ListNode(3);
        n4 = t.new ListNode(4);
    }

    @After
    public void tearDown() throws Exception {
        t = null;
    }

    @Test
    public void rotateRight0() throws Exception {
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        assertEquals(n1, t.rotateRight(n1, 0));
    }

    @Test
    public void rotateRight1() throws Exception {
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        assertEquals(n4, t.rotateRight(n1, 1));
    }

    @Test
    public void rotateRight4() throws Exception {
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        assertEquals(n1, t.rotateRight(n1, 0));
    }

    @Test
    public void rotateRight5() throws Exception {
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        assertEquals(n4, t.rotateRight(n1, 5));
    }

}