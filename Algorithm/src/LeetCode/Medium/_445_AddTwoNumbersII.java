package LeetCode.Medium;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Follow up:
 * What if you cannot modify the input lists? In other words, reversing the lists is not allowed.
 * <p>
 * Example:
 * <p>
 * Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 8 -> 0 -> 7
 */
public class _445_AddTwoNumbersII {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result;
        ListNode prevNode = new ListNode(0);
        ListNode thisNode = new ListNode(0);
        ListNode tmp1, tmp2;
        int decade, unit;

        // 获取长度
        int lenL1, lenL2;
        lenL1 = 0;
        lenL2 = 0;
        tmp1 = l1;
        tmp2 = l2;
        while (tmp1 != null) {
            lenL1++;
            tmp1 = tmp1.next;
        }
        while (tmp2 != null) {
            lenL2++;
            tmp2 = tmp2.next;
        }

        // 将两个列表对齐
        if (lenL1 > lenL2) {
            lenL1--;
            result = new ListNode(l1.val);
            l1 = l1.next;
            prevNode = result;
            while (lenL1 > lenL2) {
                lenL1--;
                thisNode = new ListNode(l1.val);
                prevNode.next = thisNode;
                prevNode = thisNode;
                l1 = l1.next;
            }
        } else if (lenL2 > lenL1) {
            lenL2--;
            result = new ListNode(l2.val);
            l2 = l2.next;
            prevNode = result;
            while (lenL2 > lenL1) {
                lenL2--;
                thisNode = new ListNode(l2.val);
                prevNode.next = thisNode;
                prevNode = thisNode;
                l2 = l2.next;
            }
        } else {
            lenL1--;
            result = new ListNode(l1.val + l2.val);
            prevNode = result;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null && l2 != null) {
            lenL1--;
            thisNode = new ListNode(l1.val + l2.val);
            prevNode.next = thisNode;
            prevNode = thisNode;
            l1 = l1.next;
            l2 = l2.next;
        }

        // 进行进位
        boolean flag = true;
        while (flag) {
            flag = false;
            prevNode = result;
            if (result.val > 9) {
                prevNode = new ListNode(1);
                prevNode.next = result;
                result = prevNode;
                prevNode = result.next;
                prevNode.val -= 10;
            }
            thisNode = prevNode.next;
            while (thisNode != null) {
                if (thisNode.val > 9) {
                    prevNode.val += 1;
                    thisNode.val -= 10;
                    flag = true;
                }
                prevNode = thisNode;
                thisNode = thisNode.next;
            }
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