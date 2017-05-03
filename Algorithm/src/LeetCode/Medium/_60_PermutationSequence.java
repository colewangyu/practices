package LeetCode.Medium;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * The set [1,2,3,…,n] contains a total of n! unique permutations.
 * <p>
 * By listing and labeling all of the permutations in order,
 * We get the following sequence (ie, for n = 3):
 * <p>
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * Given n and k, return the kth permutation sequence.
 * Note: Given n will be between 1 and 9 inclusive.
 */
public class _60_PermutationSequence {
    public String getPermutation(int n, int k) {
        StringBuilder result;
        result = new StringBuilder();

        if (n == 1 && k == 1) {
            result.append(1);
        } else {

            List<Integer> list;
            int[] factorial;  // 各个数的阶乘
            int index;
            int number;

            list = new ArrayList<Integer>();
            factorial = new int[n];
            for (int i = 1; i <= n; i++) {
                list.add(i);
            }
            factorial[0] = 1;
            factorial[1] = 1;
            for (int i = 2; i < n; i++) {
                factorial[i] = factorial[i - 1] * i;
            }
            number = k;
            for (int i = 0; i < n; i++) {
                if (i == n - 1) {
                    result.append(list.get(0));
                    break;
                }
                int tmp = factorial[list.size() - 1];
                index = (int) Math.ceil((double) number / (double) tmp);
                number -= tmp * (index - 1);
                result.append(list.get(index - 1));
                list.remove(index - 1);
            }
        }
        return result.toString();
    }
}
