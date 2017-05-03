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
        List<Integer> list;
        list = new ArrayList<Integer>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        int factorial;
        int index;
        int number;
        number = k;
        for (int i = 0; i < n; i++) {
            if (i == n - 1) {
                result.append(list.get(0));
                break;
            }
            factorial = factorial(list.size() - 1);
            index = (int) Math.ceil((double) number / (double) factorial);
            number -= factorial * (index - 1);
            result.append(list.get(index - 1));
            list.remove(index - 1);
        }
        return result.toString();
    }

    private static int factorial(int n) {
        int result = 1;
        for (int i = 2; i <= n; i++)
            result *= i;
        return result;
    }
}
