package LeetCode.Easy;

/**
 * You have a total of n coins that you want to form in a staircase shape, where every k-th row must have exactly k coins.
 * <p>
 * Given n, find the total number of full staircase rows that can be formed.
 * <p>
 * n is a non-negative integer and fits within the range of a 32-bit signed integer.
 */
public class _441_ArrayingCoins {
    public int arrangeCoins(int n) {
        if (n > 0) {
            return (int) ((Math.sqrt(8 * (double)n + 1) - 1) / 2);
        } else {
            return 0;
        }
    }
}
