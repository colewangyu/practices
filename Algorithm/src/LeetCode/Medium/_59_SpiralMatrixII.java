package LeetCode.Medium;

/**
 * Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 * <p>
 * For example,
 * Given n = 3,
 * <p>
 * You should return the following matrix:
 * [
 * [ 1, 2, 3 ],
 * [ 8, 9, 4 ],
 * [ 7, 6, 5 ]
 * ]
 */
public class _59_SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int top, button, left, right;
        int row, col;
        int index;
        top = -1;
        button = n;
        left = -1;
        right = n;
        row = 0;
        col = 0;
        index = 1;
        while (index <= n * n) {
            if (left < right) {
                while (col < right) {
                    result[row][col++] = index++;
                }
                col--;
                row++;
                top++;
            }
            if (top < button) {
                while (row < button) {
                    result[row++][col] = index++;
                }
                row--;
                col--;
                right--;
            }
            if (left < right) {
                while (col > left) {
                    result[row][col--] = index++;
                }
                col++;
                row--;
                button--;
            }
            if (top < button) {
                while (row > top) {
                    result[row--][col] = index++;
                }
                row++;
                col++;
                left++;
            }
        }
        return result;
    }
}
