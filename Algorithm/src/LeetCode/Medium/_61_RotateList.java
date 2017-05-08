package LeetCode.Medium;

/**
 * Given a list, rotate the list to the right by k places, where k is non-negative.
 * <p>
 * For example:
 * Given 1->2->3->4->5->NULL and k = 2,
 * return 4->5->1->2->3->NULL.
 */
public class _61_RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) {
            return null;
        } else {
            int len;
            int count;
            ListNode tmpHead;
            ListNode curNode;

            len = 1;
            curNode = head;
            while (curNode.next != null) {
                curNode = curNode.next;
                len++;
            }
            k %= len;
            if(k == 0)
                return head;
            count = len - k;
            curNode = head;
            while(count > 1) {
                curNode = curNode.next;
                count--;
            }
            tmpHead = curNode.next;
            curNode.next = null;
            curNode = tmpHead;
            while(curNode.next != null) {
                curNode = curNode.next;
            }
            curNode.next = head;
            head = tmpHead;
            return head;
        }
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}