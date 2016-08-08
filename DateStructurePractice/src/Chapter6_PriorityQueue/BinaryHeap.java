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
        //1. 在可插入位置上建立穴
        int hole = ++currentSize;
        //2. 与父亲节点比较，直到比父亲节点大，或者到根节点
        for (; hole > 1 && x.compareTo(array[hole / 2]) < 0; hole /= 2) {
            //2.1 移动父亲节点的值
            array[hole] = array[hole / 2];
        }
        //3. 插入值，完成上滤
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
     *  步骤：
     *    1. 保存根元素
     *    2. 遍历左右儿子，并比较左右儿子，将较小值放入父亲节点
     *    3. 重复第2步，直到下滤到顶部
     * @param hole
     */
    private void percolateDown(int hole) {
        int child;
        // 1. 保存需要更改位置的元素（最后一个元素）
        AnyType tmp = array[hole];
        // 2. 遍历左右儿子节点
        for (; hole * 2 <= currentSize; hole = child) {
            child = hole * 2;
            // 2.1 存在右儿子，并且右儿子比左儿子小
            if (child + 1 <= currentSize && array[child].compareTo(array[child + 1]) > 0) {
                // 2.1 将指针指向较小的右儿子
                child++;
            }
            // 2.2 较小的儿子与根元素比较
            if (array[child].compareTo(tmp) < 0) {
                // 2.2 如果较小儿子比根元素小则将其设置为父节点
                array[hole] = array[child];
            } else {
                break;
            }
        }
        array[hole] = tmp;
    }

    /**
     * 将乱序的数组，构造成二叉堆
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
