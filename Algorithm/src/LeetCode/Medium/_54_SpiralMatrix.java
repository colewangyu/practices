package LeetCode.Medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 */
public class _54_SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result;
        result = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0) {
            // do nothing
        } else {
            // output spiral matrix
            int rowBegin = 0;
            int rowEnd = matrix.length - 1;
            int columnBegin = 0;
            int columnEnd = matrix[0].length - 1;
            while (rowBegin <= rowEnd && columnBegin <= columnEnd) {
                //toward right
                for (int column = columnBegin; column <= columnEnd; column++) {
                    result.add(matrix[rowBegin][column]);
                }
                rowBegin++;
                //toward down
                for (int row = rowBegin; row <= rowEnd; row++) {
                    result.add(matrix[row][columnEnd]);
                }
                columnEnd--;
                //toward left
                if (rowEnd >= rowBegin) {
                    for (int column = columnEnd; column >= columnBegin; column--) {
                        result.add(matrix[rowEnd][column]);
                    }
                }
                rowEnd--;
                //toward up
                if (columnEnd >= columnBegin) {
                    for (int row = rowEnd; row >= rowBegin; row--) {
                        result.add(matrix[row][columnBegin]);
                    }
                }
                columnBegin++;
            }
        }
        return result;
    }
}
