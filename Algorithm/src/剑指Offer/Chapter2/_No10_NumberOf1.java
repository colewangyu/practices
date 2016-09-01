package 剑指Offer.Chapter2;

/**
 * Created by wy on 2016-09-01.
 */
public class _No10_NumberOf1 {
    /**
     * 【评价】最佳解法
     * 【思路】数据不为零，则对数据减一，然后与原数据相与，从而将最低位的1消除(符号位也会被计算)。
     * @param n
     * @return
     */
    public static int numberOf1(int n) {
        int count = 0;
        while(n != 0) {
            count++;
            // n - 1，然后与原数字相与
            n = (n - 1) & n;
        }
        return count;
    }
}
