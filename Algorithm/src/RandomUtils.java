import java.util.*;

/**
 * Created by wy on 2016-05-04 0004.
 */
public class RandomUtils {

    /**
     * 生成一个乱序浮点型数组
     *
     * @param startNum  开始数（所有数大于等于此数）
     * @param endNum    最大数（所有数小于此数）
     * @param arraySize 生成的数组的大小
     * @param isRepeat  数据是否可以重复
     * @return 乱序浮点型数组
     */
    public static Double[] getDisorderDoubleArray(double startNum, double endNum, int arraySize, boolean isRepeat) {
        double length;
        Double[] a;

        length = endNum - startNum;
        if (length == 0) {
            throw new IllegalArgumentException("输入参数有误：最大数（" + endNum + "）=最小数（" + startNum + "）");
        }
        a = new Double[arraySize];

        if (isRepeat == false) {
            Map<Integer, Double> map;
            double tmp;
            int index;

            map = new HashMap<Integer, Double>();


            for (int i = 0; i < arraySize; ) {
                tmp = Math.random() * length + startNum;
                if (map.containsValue(tmp)) {
                    continue;
                } else {
                    map.put(i, tmp);
                    i++;
                }
            }
            Iterator iter = map.entrySet().iterator();
            index = 0;
            while (iter.hasNext()) {
//                Map.Entry Double.entry.getValue();
                index++;
            }

        } else {
            for (int i = 0; i < arraySize; i++) {
                a[i] = Math.random() * length + startNum;
            }
        }
        return a;
    }

    /**
     * 生成一个乱序整型数组，使用endNum - startNum作为数组大小
     *
     * @param startNum 开始数（所有数大于等于此数）
     * @param endNum   最大数（所有数小于此数）
     * @param isRepeat 数据是否可以重复
     * @return 乱序整型数组
     */
    public static Integer[] getDisorderIntegerArray(int startNum, int endNum, boolean isRepeat) {
        return getDisorderIntegerArray(startNum, endNum, endNum - startNum, isRepeat);
    }

    /**
     * 生成一个乱序整型数组
     *
     * @param startNum  开始数（所有数大于等于此数）
     * @param endNum    最大数（所有数小于此数）
     * @param arraySize 期望生成的数组的大小
     * @param isRepeat  数据是否可以重复
     * @return 乱序整型数组
     */
    public static Integer[] getDisorderIntegerArray(int startNum, int endNum, int arraySize, boolean isRepeat) {
        /**
         * 允许不重复整数的最大值
         */
        int length;
        Integer[] a;

        //验证输入正确性
        length = endNum - startNum;
        //不重复的情况下，length不可小于需要的数组大小
        if (isRepeat == false && length < arraySize)
            throw new IllegalArgumentException("无法生成需求大小的数组，因为" + endNum + "(最大数) - " + startNum + "(开始数) = " + (endNum - startNum) + " < " + arraySize);

        //生成数组
        a = new Integer[arraySize];
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
