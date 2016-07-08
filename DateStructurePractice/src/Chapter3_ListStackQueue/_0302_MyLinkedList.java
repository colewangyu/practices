package Chapter3_ListStackQueue;

import java.util.Iterator;

/**
 * Created by cole on 4/13/16.
 */
public class _0302_MyLinkedList<AnyType> implements Iterable<AnyType> {
    public static void main(String[] args) {
        _0302_MyLinkedList tc = new _0302_MyLinkedList<Integer>();
        tc.add(1);
        tc.add(2);
        Iterator it = tc.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }
    }

    private int size;
    private Node headerNode;
    private Node tailNode;

    public _0302_MyLinkedList() {
        clear();
    }

    public void clear() {
        size = 0;
        headerNode = new Node(null, null, null);
        tailNode = new Node(null, null, headerNode);
    }

    public int size() {
        return size;
    }

    public void add(AnyType o) {
        add(o, size());
    }

    public void add(AnyType o, int index) {
        addBefore(o, index);
    }

    public void addBefore(AnyType o, int index) {
        Node thisNode = getNode(index);
        Node preNode = thisNode.preNode;
        Node newNode = new Node(o,thisNode,preNode);
        thisNode.preNode = newNode;
        preNode.nextNode = newNode;
    }

    public Node getNode(int index) {
        Node tmpNode;
        if(index >= 0 && index <= size) {
            if(index < size()/2) {
                tmpNode = headerNode;
                for(int i = -1; i < index; i++) {
                    tmpNode = tmpNode.nextNode;
                }
            } else {
                tmpNode = tailNode;
                for(int i = size(); i > index; i--) {
                    tmpNode = tmpNode.preNode;
                }
            }
        } else {
            throw new IndexOutOfBoundsException();
        }
        return tmpNode;
    }

    @Override
    public Iterator<AnyType> iterator() {
        return new MyLinkedListIterator(headerNode);
    }

    private class MyLinkedListIterator<AnyType> implements Iterator {
        private Node curNode;

        public MyLinkedListIterator(Node curNode) {
            this.curNode = curNode;
        }

        @Override
        public boolean hasNext() {
            return curNode.getNextNode().getObj() != null;
        }

        @Override
        public Object next() {
            curNode = curNode.getNextNode();
            return curNode.getObj();
        }

        @Override
        public void remove() {

        }
    }

    private class Node<AnyType> {
        private AnyType obj;
        private Node nextNode;
        private Node preNode;

        public Node(AnyType obj, Node nextNode, Node preNode) {
            this.obj = obj;
            this.nextNode = nextNode;
            this.preNode = preNode;
        }

        public AnyType getObj() {
            return obj;
        }

        public void setObj(AnyType obj) {
            this.obj = obj;
        }

        public Node getNextNode() {
            return nextNode;
        }

        public void setNextNode(Node nextNode) {
            this.nextNode = nextNode;
        }

        public Node getPreNode() {
            return preNode;
        }

        public void setPreNode(Node preNode) {
            this.preNode = preNode;
        }
    }
}