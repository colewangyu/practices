package LeetCode;

/**
 * Created by cole on 2016-12-04.
 * <p>
 * Divide two integers without using multiplication, division and mod operator.
 * <p>
 * If it is overflow, return MAX_INT.
 */
public class _29_DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        int result;
        result = 0;

        if (divisor == 0) {
            throw new ArithmeticException();
        } else if (dividend == 0) {
            return 0;
        }

        int tmpDivisor;
        if (divisor < 0)
            tmpDivisor = -divisor;
        else
            tmpDivisor = divisor;

        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            result = Integer.MAX_VALUE;
        } else if (dividend > 0) {
            while ((dividend -= tmpDivisor) >= 0) {
                result++;
            }
            if (divisor < 0)
                result = -result;
        } else {
            while ((dividend += tmpDivisor) <= 0) {
                result++;
            }
            if (divisor > 0)
                result = -result;
        }
        return result;
    }
}
