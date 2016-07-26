import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

/**
 * Created by cole on 2016-05-10 Tuesday.
 */
public class _2_addTwoNumbersTest {

    @Rule
    public ExpectedException expectedEx =ExpectedException.none();

    @Test
    public void testAddTwoNumbers() throws Exception {
        _2_addTwoNumbers t = new _2_addTwoNumbers();
        _2_addTwoNumbers.ListNode ln1;
        _2_addTwoNumbers.ListNode ln2;
        _2_addTwoNumbers.ListNode ln3;
        _2_addTwoNumbers.ListNode ln4;
        _2_addTwoNumbers.ListNode ln5;
        _2_addTwoNumbers.ListNode ln6;

        _2_addTwoNumbers.ListNode ln;



        ln1 = t.new ListNode(0);
        ln2 = t.new ListNode(0);
        ln3 = t.new ListNode(0);
        ln4 = t.new ListNode(0);
        ln5 = t.new ListNode(0);
        ln6 = t.new ListNode(0);

        ln1.next = ln2;
        ln2.next = ln3;
        ln4.next = ln5;
        ln5.next = ln6;

        //有效等价类
        ln1.val = 9;
        ln2.val = 9;
        ln3.val = 9;
        ln4.val = 9;
        ln5.val = 9;
        ln6.val = 9;

        ln = t.addTwoNumbers(ln1,ln4);
        assertEquals(ln.val, 8);
        ln = ln.next;
        assertEquals(ln.val, 9);
        ln = ln.next;
        assertEquals(ln.val, 9);
        ln = ln.next;
        assertEquals(ln.val, 1);
        assertNull(ln.next);

        ln1.val = 0;
        ln2.val = 0;
        ln3.val = 0;
        ln4.val = 0;
        ln5.val = 0;
        ln6.val = 0;
        ln = t.addTwoNumbers(ln1,ln4);
        assertEquals(ln.val, 0);
        ln = ln.next;
        assertEquals(ln.val, 0);
        ln = ln.next;
        assertEquals(ln.val, 0);
        assertNull(ln.next);

        ln1.val = 3;
        ln2.val = 3;
        ln3.val = 3;
        ln4.val = 3;
        ln5.val = 3;
        ln6.val = 3;
        ln = t.addTwoNumbers(ln1,ln4);
        assertEquals(ln.val, 6);
        ln = ln.next;
        assertEquals(ln.val, 6);
        ln = ln.next;
        assertEquals(ln.val, 6);
        assertNull(ln.next);

        ln1.val = 3;
        ln2.val = 3;
        ln2.next = null;
        ln4.val = 3;
        ln5.val = 3;
        ln6.val = 3;
        ln = t.addTwoNumbers(ln1,ln4);
        assertEquals(ln.val, 6);
        ln = ln.next;
        assertEquals(ln.val, 6);
        ln = ln.next;
        assertEquals(ln.val, 3);
        assertNull(ln.next);


        ln1 = null;
        ln4.val = 3;
        ln5.val = 3;
        ln6.val = 3;
        ln = t.addTwoNumbers(ln1,ln4);
        assertEquals(ln.val, 3);
        ln = ln.next;
        assertEquals(ln.val, 3);
        ln = ln.next;
        assertEquals(ln.val, 3);
        assertNull(ln.next);

        ln1 = t.new ListNode(2);
        ln1.val = 1;

        ln4.val = 9;
        ln5.val = 9;
        ln6.val = 9;
        ln = t.addTwoNumbers(ln1,ln4);
        assertEquals(ln.val, 0);
        ln = ln.next;
        assertEquals(ln.val, 0);
        ln = ln.next;
        assertEquals(ln.val, 0);
        ln = ln.next;
        assertEquals(ln.val, 1);
        assertNull(ln.next);

        //无效等价类
        expectedEx.expect(Exception.class);
        ln1.val = 10;
        ln2.val = 10;
        ln3.val = 3;
        ln4.val = 10;
        ln5.val = 3;
        ln6.val = 10;
        ln = t.addTwoNumbers(ln1,ln4);
    }
}