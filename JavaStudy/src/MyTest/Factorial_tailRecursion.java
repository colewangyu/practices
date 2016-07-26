package MyTest;

/**
 * Created by home on 2015-11-18.
 * 尾递归：递归调用时递归方法执行的最后一个语句。
 */
public class Factorial_tailRecursion {
    public static void main(String[] args) {
        Factorial_tailRecursion test = new Factorial_tailRecursion();
//        System.out.println(test.factorial_recursion(12345));
        System.out.println(test.factorail_tail_recursion(123, 1));  //实验证明Java为针对尾递归进行优化
    }

    /**
     * 计算阶乘，采用递归方法
     *
     * @param n 阶乘最大的数
     * @return 阶乘结果
     */
    public static final int factorial_recursion(int n) {
        if (n > 1)
            return factorial_recursion(n - 1) * n;
        return n;
    }

    /**
     * 计算阶乘，采用尾递归方法
     *
     * @param n 阶乘最大的数
     * @return 阶乘结果
     */
    public static final int factorail_tail_recursion(int n, int a) {
        a = a * n;
        if (n > 1)
            return factorail_tail_recursion(n - 1, a);
        return a;
    }
}
