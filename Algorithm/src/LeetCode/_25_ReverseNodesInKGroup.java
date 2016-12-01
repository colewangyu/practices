package LeetCode;

/**
 * Created by wy on 2016-12-01.
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * <p/>
 * If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 * <p/>
 * You may not alter the values in the nodes, only nodes itself may be changed.
 * <p/>
 * Only constant memory is allowed.
 * <p/>
 * For example,
 * Given this linked list: 1->2->3->4->5
 * <p/>
 * For k = 2, you should return: 2->1->4->3->5
 * <p/>
 * For k = 3, you should return: 3->2->1->4->5
 */
public class _25_ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null)
            return null;

        ListNode prev = null;
        ListNode[] cur;
        ListNode tmp;

        cur = new ListNode[k];
        tmp = head;
        while (true) {
            // 得到k个不为空的ListNode
            for (int i = 0; i < k; i++) {
                if (tmp == null)
                    return head;
                cur[i] = tmp;
                tmp = tmp.next;
            }
            // 反转
            if (prev == null)
                head = cur[k - 1];
            // 进行反转
            cur[0].next = cur[k - 1].next;
            for (int i = 1; i < k; i++) {
                cur[i].next = cur[i - 1];
            }
            // 下一轮的准备工作
            if(prev != null)
                prev.next = cur[k - 1];
            prev = cur[0];
        }
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
