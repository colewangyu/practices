package Chapter2_AlgorithmAnalysis;

import java.math.BigInteger;

/**
 * Created by wy on 2016-03-29.
 * <p>
 * GCD: Greatest Common Divisor 最大公约数
 */
public class _0203_GCD {

    /**
     * 计算公约数
     * 【原理】运用欧几里得算法，该算法依赖于该定理：两整数的最大公约数等于其中较小的那个数和两数的相除余数的最大公约数。
     * 【缺陷】取膜运算消耗较多（尤其在数值较大时）
     * 【时间复杂度】O(Max(a,b))
     * @param a
     * @param b
     * @return
     */
    static public BigInteger getGCD1(BigInteger a, BigInteger b) {
        // 输入有效性验证
        if (a == null || b == null) throw new NullPointerException();
        if (a.compareTo(BigInteger.ZERO) < 0 || b.compareTo(BigInteger.ZERO) < 0)
            throw new IllegalArgumentException("不能输入负数。");
        // 保证a > b
        if (a.compareTo(b) < 0)
            return getGCD1(b, a);

        BigInteger tmp;
        while (b.compareTo(BigInteger.ZERO) != 0) {
            tmp = a.mod(b);
            a = b;
            b = tmp;
        }
        return a;
    }

    /**
     * 计算公约数
     * 【原理】如果一数能同时整除x和y,则必能同时整除x - y 和 y，
     * 【缺陷】迭代次数过多，尤其在极端情况，比如输入（10000000,1）
     * 【时间复杂度】O(Max(a,b))
     * @param a
     * @param b
     * @return
     */
    static public BigInteger getGCD2(BigInteger a, BigInteger b) {
        // 输入有效性验证
        if (a == null || b == null) throw new NullPointerException();
        if (a.compareTo(BigInteger.ZERO) < 0 || b.compareTo(BigInteger.ZERO) < 0)
            throw new IllegalArgumentException("不能输入负数。");
        // 保证a > b
        if (a.compareTo(b) < 0)
            return getGCD2(b, a);

        BigInteger tmp;
        while (b.compareTo(BigInteger.ZERO) != 0) {
            tmp = a.subtract(b);
            if (b.compareTo(tmp) < 0) {
                a = tmp;
            } else {
                a = b;
                b = tmp;
            }
        }
        return a;
    }

    /**
     * 计算公约数
     * 【原理】结合方法一和方法二，
     * 【缺陷】无缺陷（相对于方法一和二，避免了方法一和方法二的缺陷）
     * 【时间复杂度】O(logMax(a,b))
     * @param a
     * @param b
     * @return
     */
    static public BigInteger getGCD3(BigInteger a, BigInteger b) {
        // 输入有效性验证
        if (a == null || b == null) throw new NullPointerException();
        if (a.compareTo(BigInteger.ZERO) < 0 || b.compareTo(BigInteger.ZERO) < 0)
            throw new IllegalArgumentException("不能输入负数。");
        // 保证a >= b
        if (a.compareTo(b) < 0)
            return getGCD3(b, a);

        BigInteger tmp;
        while (b.compareTo(BigInteger.ZERO) != 0) {
            if(a.and(BigInteger.ONE).compareTo(BigInteger.ONE) == 0) {
                // a为奇数的情况
                if(b.and(BigInteger.ONE).compareTo(BigInteger.ONE) == 0) {
                    // b为奇数的情况
                    return getGCD3(a.subtract(b), b);
                } else {
                    // b为偶数的情况
                    return getGCD3(a, b.shiftRight(1));
                }
            } else {
                // a为偶数的情况
                if(b.and(BigInteger.ONE).compareTo(BigInteger.ONE) == 0) {
                    // b为奇数的情况
                    return getGCD3(a.shiftRight(1),b);
                } else {
                    // b为偶数的情况
                    return getGCD3(a.shiftRight(1),b.shiftRight(1)).shiftLeft(1);
                }
            }
        }
        return a;
    }
}
