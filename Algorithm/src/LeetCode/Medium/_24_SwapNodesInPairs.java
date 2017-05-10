package LeetCode.Medium;

/**
 * Created by wy on 2016-12-01.
 * Given a linked list, swap every two adjacent nodes and return its head.
 * <p/>
 * For example,
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * <p/>
 * Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
 */
public class _24_SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null) return null;

        ListNode cur, prev = null, next;
        cur = head;
        next = cur.next;
        while (cur != null && next != null) {
            if (cur == head) {
                head = next;
                cur.next = next.next;
                next.next = cur;
            } else {
                cur.next = next.next;
                next.next = cur;
                prev.next = next;
            }
            prev = cur;
            cur = cur.next;
            if (cur == null) break;
            next = cur.next;
        }
        return head;
    }

    public static class ListNode {
        int val;
        public ListNode next;

        public ListNode(int x) {
            val = x;
        }
    }
}
