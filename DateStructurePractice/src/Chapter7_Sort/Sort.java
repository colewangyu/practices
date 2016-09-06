package Chapter7_Sort;

import Chapter6_PriorityQueue.BinaryHeap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

import static java.lang.Math.*;

/**
 * 包含多个常见排序算法
 * <p>
 * Created by wy on 2016-05-04 0004.
 */
public class Sort {

    /**
     * 根据不同的待排序数组大小选择合理的排序方法
     * 当待排序数组大小 N <= 10 时使用插入排序
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
     * 【其他】希尔增量：1，2，4，8..
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
     * 【其他】希尔增量：1，2，4，8...2K
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
        for (double gap = pow(2, (int) (log(array.length + 1) / log(2))) - 1; gap >= 1; gap = gap / 2.0 - 0.5) {  //Hibbard增量：2^k - 1
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
     * 【算法名】堆排序
     * 【算法思想】
     * 【时间复杂度】O(NlogN)
     * 【其他】
     *
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
        for (int i = 0; i < array.length; i++)
            array[i] = heap.deleteMin();
        return array;
    }

    /**
     * 【算法名】归并排序
     * 【算法思想】将待排序数组分为两部分，认为这两部分已排好序，依次将这两部分有序放入另一个数组空间中。
     * 递归进行该操作，直到待排序的两部分数组只有一个元素。
     * 【时间复杂度】O(NlogN)
     * 【其他】
     *
     * @param array 待排序的数组（接受任意实现了comparable接口的对象）
     * @return 排好序的数组
     */
    public static <T extends Comparable<? super T>> T[] mergeSort(T[] array) {
        /**
         * 数据有效性验证
         */
        if (array == null) {
            throw new NullPointerException("待排序数组为空！");
        }
        T[] tmpArr = (T[]) new Comparable[array.length];
        mergeSort(array, tmpArr, 0, array.length - 1);
        return array;
    }

    private static <T extends Comparable<? super T>> void mergeSort(T[] arr, T[] tmpArr, int left, int right) {
        if (left < right) {
            int center = (left + right) / 2;
            mergeSort(arr, tmpArr, left, center);
            mergeSort(arr, tmpArr, center + 1, right);
            merge(arr, tmpArr, left, center, right);
        }
    }

    private static <T extends Comparable<? super T>> void merge(T[] arr, T[] tmpArr, int left, int center, int right) {
        int index1 = left;
        int index2 = center + 1;
        int index = left;
        while (index1 <= center && index2 <= right) {
            if (arr[index1].compareTo(arr[index2]) < 0) {
                tmpArr[index] = arr[index1];
                index1++;
                index++;
            } else {
                tmpArr[index] = arr[index2];
                index2++;
                index++;
            }
        }
        while (index1 > center && index2 <= right) {
            tmpArr[index] = arr[index2];
            index++;
            index2++;
        }
        while (index2 > right && index1 <= center) {
            tmpArr[index] = arr[index1];
            index++;
            index1++;
        }
        // 把在tmpArr中排好序的数组写回arr
        for (int i = left; i <= right; i++) {
            arr[i] = tmpArr[i];
        }
    }

    /**
     * 【算法名】快速排序
     * 【算法思想】
     * 【时间复杂度】平均：O(NlogN)，最坏：O(N^2)
     * 【其他】
     *
     * @param array 待排序的数组（接受任意实现了comparable接口的对象）
     * @return 排好序的数组
     */
    public static <T extends Comparable<? super T>> T[] quickSort(T[] array) {
        /**
         * 数据有效性验证
         */
        if (array == null) {
            throw new NullPointerException("待排序数组为空！");
        }

        quickSort(array, 0, array.length - 1);
        return array;
    }

    /**
     * 快速排序的【递归】解法
     * @param array
     * @param left
     * @param right
     * @param <T>
     */
/*    public static <T extends Comparable<? super T>> void quickSort(T[] array, int left, int right) {
        if (left < right) {
            int i = partition(array, left, right);
            quickSort(array, left, i - 1);
            quickSort(array, i + 1, right);
        }
    }*/

    /**
     * 快速排序的【非递归】解法
     * 【原理】使用栈来保存分割的下标
     * 【效率】较递归方法略差，因为需要手动保存算法执行过程中的变量。
     * @param array
     * @param left
     * @param right
     * @param <T>
     */
    public static <T extends Comparable<? super T>> void quickSort(T[] array, int left, int right) {
        if (left < right) {
            Stack<Integer> s = new Stack();
            // 先加入右边界
            s.push(right);
            // 再加入左边界
            s.push(left);

            int i;
            while (!s.isEmpty()) {
                left = s.pop();
                right = s.pop();
                i = partition(array, left, right);
                if (i + 1 < right) {
                    s.push(right);
                    s.push(i + 1);
                }
                if (i - 1 > left) {
                    s.push(i - 1);
                    s.push(left);
                }
            }
        }
    }

    private static <T extends Comparable<? super T>> int partition(T[] array, int left, int right) {
        if (left < 0 || right >= array.length) throw new IllegalArgumentException("输入值越界");
        if (left >= right) return left;

        // 计算得出pivot
        T pivot = median3(array, left, right);
        // 划分较大元素区和较小元素区
        int i = left;
        int j = right;
        while (true) {
            // 从左边起找到第一个比pivot大的值(因为pivot放在最右边,所以先移动左边)
            while (i < j && array[i].compareTo(pivot) <= 0) {
                i++;
            }
            // 从右边起找到第一个比pivot小的值
            while (i < j && array[j].compareTo(pivot) >= 0) {
                j--;
            }
            if (i < j) {
                swap(array, i, j);
            } else {
                break;
            }
        }
        swap(array, i, right);
        return i;
    }

    private static <T extends Comparable<? super T>> T median3(T[] arr, int left, int right) {
        int center = (left + right) / 2;
        if (arr[center].compareTo(arr[left]) < 0) {
            swap(arr, center, left);
        }
        if (arr[right].compareTo(arr[left]) < 0) {
            swap(arr, left, right);
        }
        if (arr[center].compareTo(arr[right]) < 0) {
            swap(arr, center, right);
        }
//        swap(arr, center, right);
        return arr[right];
    }

    private static <T extends Comparable<? super T>> void swap(T[] arr, int index1, int index2) {
        T tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }
}
