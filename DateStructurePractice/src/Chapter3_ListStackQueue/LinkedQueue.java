package Chapter3_ListStackQueue;


import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by wy on 2016-05-11.
 */
public class LinkedQueue<AnyType> extends AbstractQueue<AnyType> {
    private ListNode head;
    private ListNode tail;
    private int curSize;

    public LinkedQueue() {
        head = new ListNode();
        tail = new ListNode();
        head.next = tail;
        tail.pre = head;
        curSize = 0;
    }

    @Override
    public Iterator<AnyType> iterator() {
        return new Itr();
    }

    @Override
    public int size() {
        return curSize;
    }


    @Override
    public boolean offer(AnyType x) {
        //判断数据有效性
        if (x == null) {
            throw new NullPointerException("不可插入Null值");
        }
        //生成节点
        ListNode n = new ListNode(x, tail.pre, tail);
        //获取最后一个节点
        ListNode preNode = tail.pre;
        //插入节点
        preNode.next = n;
        tail.pre = n;
        //修改队列大小
        curSize++;
        return false;
    }

    @Override
    public AnyType poll() {
        ListNode nextNode = head.next;
        if (curSize != 0) {
            AnyType tmp = nextNode.val;
            head.next = nextNode.next;
            nextNode.pre = head;
            nextNode.pre = null;
            nextNode.next = null;
            curSize--;
            return tmp;
        } else {
            return null;
        }
    }

    @Override
    public AnyType peek() {
        if (curSize != 0) {
            return head.next.val;
        } else {
            return null;
        }
    }

    private class ListNode {
        private AnyType val;
        private ListNode pre;
        private ListNode next;

        public ListNode() {
        }

        public ListNode(AnyType val, ListNode pre, ListNode next) {
            this.val = val;
            this.pre = pre;
            this.next = next;
        }
    }

    private class Itr implements Iterator<AnyType> {

        /**
         * 当前会被返回的Node
         */
        ListNode curNode = head.next;



        @Override
        public boolean hasNext() {
            return curNode != tail;
        }

        @Override
        public AnyType next() {
            if (hasNext()) {
                AnyType a = curNode.val;
                curNode = curNode.next;
                return a;
            } else {
                throw new NoSuchElementException();
            }
        }

        @Override
        public void remove() {

        }
    }
}
