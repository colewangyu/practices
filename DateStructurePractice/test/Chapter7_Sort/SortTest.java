package Chapter7_Sort;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by wy on 2016-05-04 0004.
 */
public class SortTest {
    //待测数组
    static Integer[] test01;
    static Integer[] test02;
    static Integer[] test03;
    static Integer[] test04;//10k
    static Integer[] test05;//100k
    static Integer[] test06;//1m
    static Character[] test11;
    static Character[] test12;
    static Double[] test21;
    static Double[] test22;

    static Integer[] a,b,c;


    @BeforeClass
    public static void beforeClass() {
        test01 = new Integer[]{2, 1, 3, 5, 4};
        test02 = null;
        test03 = new Integer[]{1};
        test04 = getDisorderIntegerArray(0, 10000,10000, false);
        test05 = getDisorderIntegerArray(0,100000,10000,false);
//        test06 = RandomUtils.getDisorderIntegerArray(0,1000000,false);
        test11 = new Character[]{'c', 'a', 'b', 'e', 'd'};
        test12 = new Character[]{'c'};
        test21 = new Double[]{3.33, 1.11, 2.22, 5.55, 4.44};
        test22 = new Double[]{1.11};

        a = new Integer[10000];
        for (int i = 0; i < a.length; i++) {
            a[i] = i;
        }
        b = new Integer[100000];
        for (int i = 0; i < b.length; i++) {
            b[i] = i;
        }
        c = new Integer[1000000];
        for (int i = 0; i < c.length; i++) {
            c[i] = i;
        }
    }

    @Rule
    public ExpectedException expectedEx =ExpectedException.none();

    @Test
    public void testInsertSort() throws Exception {
        expectedEx.expect(NullPointerException.class);
        expectedEx.expectMessage("待排序数组为空！");
        Assert.assertArrayEquals(Sort.insertSort(test01), new Integer[]{1, 2, 3, 4, 5});
        Assert.assertNull(Sort.insertSort(test02));
        Assert.assertArrayEquals(Sort.insertSort(test03), new Integer[]{1});

        Assert.assertArrayEquals(Sort.insertSort(test04), a);

        Assert.assertArrayEquals(Sort.insertSort(test05), b);

       // Assert.assertArrayEquals(Sort.insertSort(test06), c);
        Assert.assertArrayEquals(Sort.insertSort(test11), new Character[]{'a', 'b', 'c', 'd', 'e'});
        Assert.assertArrayEquals(Sort.insertSort(test12), new Character[]{'c'});
        Assert.assertArrayEquals(Sort.insertSort(test21), new Double[]{1.11, 2.22, 3.33, 4.44, 5.55});
        Assert.assertArrayEquals(Sort.insertSort(test22), new Double[]{1.11});
    }

    @Test
    public void testShellSort() throws Exception {
        expectedEx.expect(NullPointerException.class);
        expectedEx.expectMessage("待排序数组为空！");
        Assert.assertArrayEquals(Sort.shellSort(test01), new Integer[]{1, 2, 3, 4, 5});
        Assert.assertNull(Sort.shellSort(test02));
        Assert.assertArrayEquals(Sort.shellSort(test03), new Integer[]{1});

        Assert.assertArrayEquals(Sort.shellSort(test04), a);

        Assert.assertArrayEquals(Sort.shellSort(test05), b);

//        Assert.assertEquals(Sort.shellSort(test06), c);
        Assert.assertArrayEquals(Sort.shellSort(test11), new Character[]{'a', 'b', 'c', 'd', 'e'});
        Assert.assertArrayEquals(Sort.shellSort(test12), new Character[]{'c'});
        Assert.assertArrayEquals(Sort.shellSort(test21), new Double[]{1.11, 2.22, 3.33, 4.44, 5.55});
        Assert.assertArrayEquals(Sort.shellSort(test22), new Double[]{1.11});
    }

    @Test
    public void testHeapSort() throws Exception {
        Assert.assertArrayEquals(Sort.heapSort(test01), new Integer[]{1, 2, 3, 4, 5});
        expectedEx.expect(NullPointerException.class);
        expectedEx.expectMessage("待排序数组为空！");
        Assert.assertNull(Sort.heapSort(test02));
        Assert.assertArrayEquals(Sort.heapSort(test03), new Integer[]{1});

        Assert.assertArrayEquals(Sort.heapSort(test04), a);

        Assert.assertArrayEquals(Sort.heapSort(test05), b);

//        Assert.assertEquals(Sort.heapSort(test06), c);
        Assert.assertArrayEquals(Sort.heapSort(test11), new Character[]{'a', 'b', 'c', 'd', 'e'});
        Assert.assertArrayEquals(Sort.heapSort(test12), new Character[]{'c'});
        Assert.assertArrayEquals(Sort.heapSort(test21), new Double[]{1.11, 2.22, 3.33, 4.44, 5.55});
        Assert.assertArrayEquals(Sort.heapSort(test22), new Double[]{1.11});
    }

    @Test
    public void testMergeSort() throws Exception {

    }

    @Test
    public void testQuickSort() throws Exception {

    }

    /**
     * 生成一个乱序整型数组
     *
     * @param startNum  开始数（所有数大于等于此数）
     * @param endNum    最大数（所有数小于此数）
     * @param arraySize 生成的数组的大小
     * @param isRepeat  数据是否可以重复
     * @return 乱序整型数组
     */
    public static Integer[] getDisorderIntegerArray(int startNum, int endNum, int arraySize, boolean isRepeat) {
        int length;
        Integer[] a;

        length = endNum - startNum;
        if (length < arraySize)
            return null;
        a = new Integer[length];

        if (isRepeat == false) {
            List<Integer> list;
            list = new LinkedList<Integer>();
            for (int i = 0; i < arraySize; i++) {
                list.add(i + startNum);
            }

            for (int i = 0; i < arraySize; i++) {
                a[i] = list.remove((int) (Math.random() * list.size()));
            }
        } else {
            for (int i = 0; i < length; i++) {
                a[i] = (int) Math.random() * length + startNum;
            }
        }
        return a;
    }
}