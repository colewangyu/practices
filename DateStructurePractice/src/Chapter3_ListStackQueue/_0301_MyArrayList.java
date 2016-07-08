package Chapter3_ListStackQueue;

import java.util.Iterator;

/**
 * Created by wy on 2016-04-13.
 */
public class _0301_MyArrayList<AnyType> implements Iterable<AnyType> {
    private static final int DefaultCapacity = 10;  //默认初始容量

    private int size; //列表当前大小
    private AnyType[] list;

    public _0301_MyArrayList() {
        this.size = 0;
        this.list = (AnyType[]) new Object[DefaultCapacity];
    }

    public int size() {
        return this.size;
    }

    /**
     * 确保MyArrayList的容量是否够用，如果不够用则进行扩容
     *
     * @param newCapacity
     */
    public void ensureCapacity(int newCapacity) {
        if (newCapacity <= list.length) {
            return;
        } else {
            //扩容
            AnyType[] newList = (AnyType[]) new Object[size() * 2];
            for (int i = 0; i < size(); i++) {
                newList[i] = list[i];
            }
            list = newList;
        }
    }

    /**
     * 获取指定位置的对象，index从0开始计算
     * @param index
     * @return
     */
    public AnyType get(int index) {
        if (index < size() && index >= 0)
            return list[index];
        else
            throw new ArrayIndexOutOfBoundsException();
    }

    /**
     * 在列表末尾添加对象
     *
     * @param o
     */
    public void add(AnyType o) {
        add(o, size());
    }

    /**
     * 在指定位置添加指定对象，index从0开始计算
     *
     * @param o
     * @param index
     */
    public void add(AnyType o, int index) {
        //确保容量够用
        ensureCapacity(size() + 1);
        //插入
        for (int i = size(); i > index; i--) {
            list[i] = list[i - 1];
        }
        list[index] = o;
        size++;
    }

    /**
     * 删除指定位置的对象，index从0开始计算
     *
     * @param index
     */
    public void remove(int index) {
        if (size() > 0) {
            for (int i = index; i < size() - 1; i++) {
                list[i] = list[i + 1];
            }
            size--;
        } else {
            return;
        }
    }

    /**
     * 获取该对象的遍历器
     * @return
     */
    @Override
    public java.util.Iterator<AnyType> iterator() {
        return new MyArrayListIterator();
    }

    private class MyArrayListIterator implements Iterator<AnyType> {
        private int current; //当前读取到的位置

        public MyArrayListIterator() {
            current = 0;
        }

        @Override
        public boolean hasNext() {
            return current < size();
        }

        @Override
        public AnyType next() {
            return list[current++];
        }

        @Override
        public void remove() {
            _0301_MyArrayList.this.remove(current--);
        }
    }
}
