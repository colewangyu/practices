import org.w3c.dom.NodeList;

/**
 * Created by cole on 2016-05-10 Tuesday.
 */
public class _2_addTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) throws Exception {
        ListNode lt, l;
        int gw; //个位
        int sw; //十位

        l = new ListNode(0);
        lt = l;
        gw = 0;
        sw = 0;
        while (l1 != null || l2 != null || sw != 0) {
            //数据有效性判断
            if((l1 != null && (l1.val > 9 || l1.val < 0)) || (l2 != null && (l2.val > 9 || l2.val < 0))) {
                throw new Exception();
            }
            //处理数据
            if(l1 == null) {
                l1 = new ListNode(0);
            }
            if(l2 == null) {
                l2 = new ListNode(0);
            }
            //计算数据
            gw = (l1.val + l2.val + sw) % 10;
            sw = (l1.val + l2.val + sw) / 10;
            //处理计算结果
            lt.val = gw;
            //准备下一次循环
            l1 = l1.next;
            l2 = l2.next;
            if(l1 != null || l2 != null || sw != 0) {
                lt.next = new ListNode(0);
                lt = lt.next;
            }

        }
        lt = null;
        return l;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
