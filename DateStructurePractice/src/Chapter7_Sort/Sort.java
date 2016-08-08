package Chapter7_Sort;

import Chapter6_PriorityQueue.BinaryHeap;

import java.util.Arrays;
import java.util.Comparator;

import static java.lang.Math.*;

/**
 * 包含多个常见排序算法
 * <p/>
 * Created by wy on 2016-05-04 0004.
 */
public class Sort {

    /**
     * 根据不同的待排序数组大小选择合理的排序方法
     * 当待排序数组大小 N <= 10 时使用插入排序
     *
     *
     * @param array
     * @param <T>
     * @return
     */
    public static <T extends Comparable<? super T>> T[] sort(T[] array) {  //T必须实现或继承Comparable，T可以比较的类型为T或者T的父类。
        Arrays.sort(array);
        //TODO
        return null;
    }

    /**
     * 【算法名】插入排序
     * 【算法思想】将数据一个个地插入到排好序的数组中
     * 【时间复杂度】采用希尔增量：O(N^2)，采用Hibbard增量：O(N^(3/2))
     * 希尔增量：1，2，4，8..
     *
     * @param array 待排序的数组（接受任意实现了comparable接口的对象）
     * @return 从小到大（正序）排好序的数组
     */
    public static <T extends Comparable<? super T>> T[] insertSort(T[] array) {
        /**
         * 数据有效性验证
         */
        if (array == null) {
            throw new NullPointerException("待排序数组为空！");
        }
        /**
         * 插入排序主体
         */
        for (int i = 1; i < array.length; i++) {
            T tmp = array[i];
            int j;
            for (j = i; j > 0; j--) {
                if (tmp.compareTo(array[j - 1]) < 0) {
                    array[j] = array[j - 1];
                } else {
                    break;
                }
            }
            array[j] = tmp;
        }
        return array;
    }

    /**
     * 【算法名】希尔排序（缩减增量排序）
     * 【算法思想】插入排序的改进，每次比较一个固定间隔的数据，然后逐渐缩小间隔直至间隔为1
     * 【时间复杂度】采用希尔增量：O(N^2)，采用希巴德（Hibbard）增量：O(N^(3/2))
     * 希尔增量：1，2，4，8...2K
     * 希巴德增量：1，3，7，...，2^k - 1
     *
     * @param array 待排序的数组（接受任意实现了comparable接口的对象）
     * @return 从小到大（正序）排好序的数组
     */
    public static <T extends Comparable<? super T>> T[] shellSort(T[] array) {
        /**
         * 数据有效性验证
         */
        if (array == null) {
            throw new NullPointerException("待排序数组为空！");
        }
        /**
         * 希尔排序主体
         */

        //for(int gap = array.length / 2; gap >= 1; gap /= 2) {  //希尔增量：2k
        for (double gap = pow(2, (int)(log(array.length + 1)/log(2))) - 1; gap >= 1; gap = gap / 2.0 - 0.5) {  //Hibbard增量：2^k - 1
            int gapInt = (int) gap;
            for (int i = gapInt; i < array.length; i += gap) {
                T tmp = array[i];
                int j;
                for (j = i; j > 0; j -= gap) {
                    if (array[j].compareTo(array[j - gapInt]) < 0) {
                        array[j] = array[j - gapInt];
                    } else {
                        break;
                    }
                }
                array[j] = tmp;
            }
        }
        return array;
    }

    /**
     * @param array 待排序的数组（接受任意实现了comparable接口的对象）
     * @return 排好序的数组
     */
    public static <T extends Comparable<? super T>> T[] heapSort(T[] array) {
        /**
         * 数据有效性验证
         */
        if (array == null) {
            throw new NullPointerException("待排序数组为空！");
        }

        /**
         * 堆排序主体
         */
        BinaryHeap<T> heap = new BinaryHeap(array);
        for(int i = 0; i < array.length; i++)
            array[i] = heap.deleteMin();
        return array;
    }

    /**
     * @param array 待排序的数组（接受任意实现了comparable接口的对象）
     * @return 排好序的数组
     */
    public static <T extends Comparable<? super T>> T[] mergeSort(T[] array) {
        return null;
    }

    /**
     * @param array 待排序的数组（接受任意实现了comparable接口的对象）
     * @return 排好序的数组
     */
    public static <T extends Comparable<? super T>> T[] quickSort(T[] array) {
        return null;
    }
}
