package Chapter6_PriorityQueue;

import java.nio.BufferUnderflowException;

/**
 * Created by wy on 2016-05-10.
 * <p/>
 * 二叉堆（运用最多的堆，通常说的堆就是二叉堆）
 * <p/>
 * 【堆序性质】父亲节点关键字小于本节点关键字（根节点最小）
 * 【基本堆操作】insert、deleteMin
 * 【其他堆操作】
 */
public class BinaryHeap<AnyType extends Comparable<? super AnyType>> {
    public BinaryHeap() {
        this(DEFAULT_CAPACITY);
    }

    public BinaryHeap(int capacity) {
        array = (AnyType[]) new Comparable[capacity + 1];
        currentSize = 0;
    }

    public BinaryHeap(AnyType[] items) {
        currentSize = items.length;
        /*不明白*/
        array = (AnyType[]) new Comparable[(currentSize + 2) * 11 / 10];
        int i = 1;
        for (AnyType item : items) {
            array[i++] = item;
        }
        buildHeap();
    }

    /**
     * 在下一个可插入位置（不能破坏完全二叉树的结构）插入一个空穴，使用上滤来找到其正确的位置
     *
     * @param x
     */
    public void insert(AnyType x) {
        if (currentSize == array.length)
            enlargeArray(array.length * 2 + 1);

        //上滤
        int hole = ++currentSize;
        for (; hole > 1 && x.compareTo(array[hole / 2]) < 0; hole /= 2) {
            array[hole] = array[hole / 2];
        }
        array[hole] = x;
    }

    public AnyType findMin() {
        if (isEmpty()) {
            throw new BufferUnderflowException();
        }
        return array[1];
    }

    public AnyType deleteMin() {
        if (isEmpty()) {
            throw new BufferUnderflowException();
        }
        AnyType minItem = findMin();
        array[1] = array[currentSize--];
        percolateDown(1);
        return minItem;
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    public void makeEmpty() {
        currentSize = 0;
    }

    private static final int DEFAULT_CAPACITY = 10;

    private int currentSize;
    private AnyType[] array;

    /**
     * 下滤
     *
     * @param hole
     */
    private void percolateDown(int hole) {
        int child;
        AnyType tmp = array[hole];
        for (; hole * 2 <= currentSize; hole = child) {
            child = hole * 2;
            if (child + 1 <= currentSize && array[child].compareTo(array[child + 1]) > 0) {
                child++;
                if (array[child].compareTo(tmp) < 0) {
                    array[hole] = array[child];
                } else {
                    break;
                }
            }
        }
        array[hole] = tmp;
    }

    /**
     * 将乱序的数组，狗造成二叉堆
     */
    private void buildHeap() {
        for (int i = currentSize / 2; i > 0; i--) {
            percolateDown(i);
        }
    }

    private void enlargeArray(int newSize) {
        AnyType[] old = array;
        array = (AnyType[]) new Comparable[newSize];
        int i = 0;
        for (AnyType item : old) {
            array[i++] = item;
        }
    }

}
