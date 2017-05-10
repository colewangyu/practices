package LeetCode.Medium;

/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * <p/>
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * <p/>
 * How many possible unique paths are there?
 * <p/>
 * Note: m and n will be at most 100.
 */
public class _62_UniquePaths {
    public int uniquePaths(int m, int n) {
        int result;
        result = 0;
        result += findPath(result, 1, 1, m, n);
        return result;
    }

    private int findPath(int result, int row, int col, int m, int n) {
        if (row == m && col == n) {
            return 1;
        } else if (row == m) {
            result += findPath(result, row, col + 1, m, n);
        } else if (col == n) {
            result += findPath(result, row + 1, col, m, n);
        } else {
            int tmpResult;
            tmpResult = result;
            result += findPath(tmpResult, row + 1, col, m, n);
            result += findPath(tmpResult, row, col + 1, m, n);
        }
        return result;
    }
}
