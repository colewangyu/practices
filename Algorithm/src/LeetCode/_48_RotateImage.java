package LeetCode;

public class _48_RotateImage {
    public void rotate(int[][] matrix) {
        // MxN, 第i排->第N-i列, 第j排变成第i列
        int[][] result;
        int length = matrix.length;
        int height = matrix[0].length;
        result = new int[height][length];
        for(int i = 0; i < length; i++) {
            for(int j = 0; j < height; j++) {
                result[j][height - 1 - i] = matrix[i][j];
            }
        }
        for(int i = 0; i < length; i++) {
            for(int j = 0; j < height; j++) {
                matrix[i][j] = result[i][j];
            }
        }
    }
}
