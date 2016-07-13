package Chapter3_ListStackQueue;

import java.util.AbstractQueue;
import java.util.Arrays;
import java.util.Iterator;

/**
 * Created by wy on 2016-05-11.
 */
public class ArrayQueue<AnyType> extends AbstractQueue<AnyType> {
    private static final int DEFAULT_CAPACITY = 10;
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
    private AnyType[] array;
    private int curSize;
    private int head;
    private int tail;

    public ArrayQueue() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayQueue(int capacity) {
        array = (AnyType[]) new AbstractQueue[capacity];
        this.curSize = 0;
        head = tail = 0;
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
        //验证输入数据
        if (x == null) {
            throw new NullPointerException();
        }
        //判断是否可以插入
        if (curSize == array.length)
            //不能插入则增大队列容量
            grow(curSize + 1);
        //执行插入
        array[tail++] = x;
        curSize++;
        if (tail >= array.length)
            tail -= array.length;
        return false;
    }

    /**
     * 增加队列的容量
     *
     * @param minCapacity 期望的最小容量
     */
    private void grow(int minCapacity) {
        //获取当前容量
        int oldCapacity = array.length;
        //获取到新的容量（计算方法：如果队列小于64则变为当前容量的两倍，否则增加50%）
        int newCapacity = (oldCapacity < 64) ? oldCapacity << 2 : (oldCapacity + oldCapacity >> 2);
        //判断新容量是否合法
        if (newCapacity < minCapacity)
            newCapacity = minCapacity;
        if (newCapacity > MAX_ARRAY_SIZE)
            newCapacity = MAX_ARRAY_SIZE;
        //增加array大小
        array = Arrays.copyOf(array, newCapacity);
    }

    @Override
    public AnyType poll() {
        if (curSize > 0)
            return array[head];
        else
            return null;
    }

    @Override
    public AnyType peek() {
        //判断是否可以出队列
        if (curSize > 0) {
            //执行出队列
            AnyType a = array[head];
            curSize--;
            head++;
            if (head >= array.length)
                head -= array.length;
            return a;
        }
        return null;
    }

    private class Itr implements Iterator<AnyType> {
        /**
         * 将被返回的下标
         */
        private int cursor = 0;

        @Override
        public boolean hasNext() {
            return cursor < curSize;
        }

        @Override
        public AnyType next() {
            return null;
        }

        @Override
        public void remove() {

        }
    }
}
