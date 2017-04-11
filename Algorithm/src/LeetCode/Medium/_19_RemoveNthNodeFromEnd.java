package LeetCode.Medium;

/**
 * Created by cole on 2016-11-24.
 */
public class _19_RemoveNthNodeFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) throw new NullPointerException();
        ListNode curNode = head;
        int len = 1;
        while (curNode.next != null) {
            curNode = curNode.next;
            len++;
        }
        if (len < n) throw new IllegalArgumentException();
        n = len - n;
        if(n == 0) {
            // 删掉第一个点
            if(head.next != null)
                head = head.next;
            else
                head = null;
        } else {
            curNode = head;
            while (n > 1) {
                curNode = curNode.next;
                n--;
            }
            if(curNode.next != null && curNode.next.next != null)
                curNode.next = curNode.next.next;
            else {
                curNode.next = null;
            }
        }
        return head;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}



