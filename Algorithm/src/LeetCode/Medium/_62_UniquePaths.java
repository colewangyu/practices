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
        int[][] map;
        map = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0)
                    map[i][j] = 1;
                else
                    map[i][j] = map[i - 1][j] + map[i][j - 1];
            }
        }
        return map[m - 1][n - 1];
    }
}
