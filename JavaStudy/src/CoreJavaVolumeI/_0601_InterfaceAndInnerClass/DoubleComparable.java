package CoreJavaVolumeI._0601_InterfaceAndInnerClass;

/**
 * Created by wy on 2016-07-25.
 */
public class DoubleComparable implements Comparable<DoubleComparable> {
    public static void main(String[] args) {
        double d1 = 0.9999999999999999;
        double d2 = 0.9999999999999999;

        System.out.println(compareDouble(d1,d2));
        System.out.println(Double.compare(d1, d2));
    }

    public static int compareDouble(double d1, double d2) {
        double result;
        result = d1 - d2;
        if(result > 0) return 1;
        else if(result < 0) return -1;
        else return 0;
    }

    @Override
    public int compareTo(DoubleComparable o) {
        //TODO 需要完善对象比较的逻辑
        return 0;
    }
}
