package LeetCode.Medium;

/**
 * Created by cole on 2016-12-04.
 * <p>
 * Divide two integers without using multiplication, division and mod operator.
 * <p>
 * If it is overflow, return MAX_INT.
 */
public class _29_DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        if (divisor == 0) {
            throw new ArithmeticException("divide zero.");
        }

        int result;
        boolean isNegative;
        int digital;

        result = 0;
        isNegative = (dividend ^ divisor) >>> 31 == 1;
        // 处理溢出情况
        if (dividend == Integer.MIN_VALUE) {
            dividend += Math.abs(divisor);
            if(divisor == -1)
                return Integer.MAX_VALUE;
            result++;
        }

        if(divisor == Integer.MIN_VALUE) {
            return result;
        }

        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        digital = 0;
        while (divisor <= dividend >>> 1) {  //此代码的关键,divisor不断x2与dividend/2比较
            divisor <<= 1;
            digital++;
        }

        while (digital >= 0) {
            if(dividend >= divisor) {
                result += 1 << digital;
                dividend -= divisor;
            }
            divisor >>= 1;
            digital--;
        }

        return isNegative ? -result : result;
    }
}
