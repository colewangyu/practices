package LeetCode.Medium;

/**
 * Implement pow(x, n).
 * 时间复杂度为log(n)
 */
public class _50_Pow {
    public double myPow(double x, int n) {
        double result;
        result = 1;
        if (n < 0) {
            while (n < -1) {
                if (-n % 2 == 1) {
                    result *= x;
                    n++;
                } else {
                    x *= x;
                    n >>= 1;
                }
            }
            result = 1 / (result * x);
        } else if (n > 0) {
            while (n > 1) {
                if (n % 2 == 1) {
                    result *= x;
                    n--;
                } else {
                    x *= x;
                    n >>= 1;
                }
            }
            result *= x;
        }
        return result;
    }
}
