package CoreJavaVolumeI._0601_InterfaceAndInnerClass;

/**
 * Created by wy on 2016-07-25.
 */
public class Minmax {
    public static class Pair {
        private double min;
        private double max;

        /**
         * 会自动判断min和max的大小来进行初始化
         * @param min
         * @param max
         */
        public Pair(double min, double max) {
            if(min > max) {
                min = min - max;
                max = max + min;
                min = max - min;
            }
            this.min = min;
            this.max = max;
        }

        public double getMin() {
            return min;
        }

        public void setMin(double min) {
            this.min = min;
        }

        public double getMax() {
            return max;
        }

        public void setMax(double max) {
            this.max = max;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (Double.compare(pair.min, min) != 0) return false;
            return Double.compare(pair.max, max) == 0;

        }

        @Override
        public int hashCode() {
            int result;
            long temp;
            temp = Double.doubleToLongBits(min);
            result = (int) (temp ^ (temp >>> 32));
            temp = Double.doubleToLongBits(max);
            result = 31 * result + (int) (temp ^ (temp >>> 32));
            return result;
        }
    }

    /**
     * 计算double数组的最大最小值，并返回一个Pair对象
     *
     * @param values double数组
     * @return Pair对象
     */
    public static Pair getMinMax(double[] values) {
        //计算values中的最大最小值
        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;
        for(double d : values) {
            if(d < min) min = d;
            if(d > max) max = d;
        }
        //使用Pair对象封装最大最小值并返回
        return new Pair(max, min);
    }
}
