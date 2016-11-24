package LeetCode;

/**
 * Created by cole on 2016-11-24.
 */
public class _21_MergeTwoSortedList {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode curNode = null;
        if(l1!=null && l2!=null) {
            if(l1.val < l2.val) {
                head = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                head = new ListNode(l2.val);
                l2 = l2.next;
            }
            curNode = head;
            while(l1 != null && l2 != null) {
                if(l1.val < l2.val) {
                    curNode.next = new ListNode(l1.val);
                    l1 = l1.next;
                } else {
                    curNode.next = new ListNode(l2.val);
                    l2 = l2.next;
                }
                curNode = curNode.next;
            }
            while(l1 != null) {
                curNode.next = new ListNode(l1.val);
                curNode = curNode.next;
                l1 = l1.next;
            }
            while(l2 != null) {
                curNode.next = new ListNode(l2.val);
                curNode = curNode.next;
                l2 = l2.next;
            }
        } else if(l1 != null) {
            head = new ListNode(l1.val);
            l1 = l1.next;
            curNode = head;
            while(l1 != null) {
                curNode.next = new ListNode(l1.val);
                curNode = curNode.next;
                l1 = l1.next;
            }
        } else if(l2 != null) {
            head = new ListNode(l2.val);
            l2 = l2.next;
            curNode = head;
            while(l2 != null) {
                curNode.next = new ListNode(l2.val);
                curNode = curNode.next;
                l2 = l2.next;
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
