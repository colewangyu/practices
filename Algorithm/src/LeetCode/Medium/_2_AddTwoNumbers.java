package LeetCode.Medium;

/**
 * Created by wy on 2016-11-14.
 * <p/>
 * You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * <p/>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 */
public class _2_AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode lt, l;
        int tens; //个位
        int units; //十位

        l = new ListNode(0);
        lt = l;
        tens = 0;
        while (l1 != null || l2 != null || tens != 0) {
            //数据有效性判断
            if ((l1 != null && (l1.val > 9 || l1.val < 0)) || (l2 != null && (l2.val > 9 || l2.val < 0))) {
                return null;
            }
            //处理数据
            if (l1 == null) {
                l1 = new ListNode(0);
            }
            if (l2 == null) {
                l2 = new ListNode(0);
            }
            //计算数据
            units = (l1.val + l2.val + tens) % 10;
            tens = (l1.val + l2.val + tens) / 10;
            //处理计算结果
            lt.val = units;
            //准备下一次循环
            l1 = l1.next;
            l2 = l2.next;
            if (l1 != null || l2 != null || tens != 0) {
                lt.next = new ListNode(0);
                lt = lt.next;
            }

        }
        lt = null;
        return l;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
