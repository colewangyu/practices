import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by wy on 2016-05-04 0004.
 */
public class RandomUtilsTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testGetDisorderDoubleArray() throws Exception {
        double start = 0;
        double end = 10000;
        int length = 10000;
        boolean isRepeat = false;
        boolean flag;

        Double[] a = RandomUtils.getDisorderDoubleArray(start, end, length, isRepeat);

        //验证数据范围正确性
        flag = true;
        for (int i = 0; i < length; i++) {
            flag = a[i] >= start && a[i] < end;
            if (flag == false)
                break;
        }
        Assert.assertTrue(flag);

        //验证数据不相等
        flag = true;
        for (int i = 0; i < length - 1 && flag == true; i++) {
            for (int j = i + 1; j < length; j++) {
                if (a[i] == a[j]) {
                    flag = false;
                    break;
                }

            }
        }
        Assert.assertTrue(flag);
    }

    @Test
    public void testGetDisorderIntegerArray() throws Exception {
        int start;
        int end;
        int length;
        int size;
        boolean isRepeat;
        boolean flag;
        Integer[] a;

        start = 0;
        end = 10000;
        length = end - start;
        isRepeat = false;
        a = RandomUtils.getDisorderIntegerArray(start, end, isRepeat);
        flag = isRangeCorrect(start, end, length, a);
        Assert.assertTrue(flag);
        flag = isDataCorrect(start, end, length, a);
        Assert.assertTrue(flag);

        start = 1000;
        end = 10000;
        length = end - start;
        isRepeat = false;
        a = RandomUtils.getDisorderIntegerArray(start, end, isRepeat);
        flag = isRangeCorrect(start, end, length, a);
        Assert.assertTrue(flag);
        flag = isDataCorrect(start, end, length, a);
        Assert.assertTrue(flag);

        start = 100;
        end = 100;
        length = end - start;
        isRepeat = false;
        a = RandomUtils.getDisorderIntegerArray(start, end, isRepeat);
        flag = isRangeCorrect(start, end, length, a);
        Assert.assertTrue(flag);
        flag = isDataCorrect(start, end, length, a);
        Assert.assertTrue(flag);

        start = 100;
        end = 1000;
        length = end - start;
        size = 1000;
        isRepeat = false;
        thrown.expect(IllegalArgumentException.class);
        a = RandomUtils.getDisorderIntegerArray(start, end, size, isRepeat);
    }

    /**
     * 验证数据范围正确性
     *
     * @param start
     * @param end
     * @param length
     * @param a
     * @return
     */
    private boolean isRangeCorrect(int start, int end, int length, Integer[] a) {
        boolean flag = true;
        for (int i = 0; i < length; i++) {
            flag = a[i] >= start && a[i] < end;
            if (flag == false)
                break;
        }
        return flag;
    }

    /**
     * 验证数据不相等
     *
     * @param start
     * @param end
     * @param length
     * @param a
     * @return
     */
    private boolean isDataCorrect(int start, int end, int length, Integer[] a) {
        boolean flag = true;
        for (int i = 0; i < length; i++) {
            flag = a[i] >= start && a[i] < end;
            if (flag == false)
                break;
        }
        return flag;
    }
}