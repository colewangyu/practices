package LeetCode;

import java.util.PriorityQueue;

/**
 * Created by cole on 2016-11-30.
 */
public class _22_MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode result = null;
        PriorityQueue<Integer> pq;
        ListNode cur;
        ListNode next;
        Integer tmp;

        pq = new PriorityQueue<Integer>();
        for (int i = 0; i < lists.length; i++) {
            cur = lists[i];
            while (cur != null) {
                pq.add(cur.val);
                cur = cur.next;
            }
        }
        if((tmp = pq.poll()) != null) {
            cur = new ListNode(tmp);
            result = cur;
        } else {
            return null;
        }
        while ((tmp = pq.poll()) != null) {
            next = new ListNode(tmp);
            cur.next = next;
            cur = next;
        }
        return result;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
