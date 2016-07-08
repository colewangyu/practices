package Chapter2_AlgorithmAnalysis;

/**
 * Created by wy on 2016-03-29.
 * <p/>
 * GCD: Greatest Common Divisor 最大公约数
 */
public class _0203_GCD {

    public static void main(String[] args) {
        System.out.println(getGCD(2, -4));
    }

    /**
     * 计算公约数
     * 运用欧几里得算法，该算法依赖于该定理：两整数的最大公约数等于其中较小的那个数和两数的相除余数的最大公约数。
     *
     * @param a
     * @param b
     * @return
     */
    static public int getGCD(int a, int b) {
        int tmp;

        if (a < 0)
            a = Math.abs(a);
        if (b < 0)
            b = Math.abs(b);

        //交换两数原理：一个数与另一个数连续计算两次异或仍未该数
        if (a < b) {
            a = a ^ b;
            b = a ^ b;
            a = a ^ b;
        }
        tmp = 0;
        while (b != 0) {
            tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }
}
