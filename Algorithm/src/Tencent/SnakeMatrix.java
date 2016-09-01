package Tencent;

import java.util.Scanner;

/**
 * Created by wy on 2016-09-01.
 * <p/>
 * 顺时针蛇形数组
 */
public class SnakeMatrix {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[][] ints = new int[N][N];
        // 上下左右四个边界的下标
        int top, bottom, left, right;
        left = top = 0;
        bottom = right = N - 1;
        // 总的计数
        int count = 1;
        // 标记此处输出的方向，每次只能有一个为true，且必须按右下左上顺序依次循环。
        boolean canTop, canBottom, canLeft, canRight;
        canTop = canBottom = canLeft = false;
        canRight = true;
        // 方向的计数，向一个方向输出一次加一
        int time = 0;
        N--;
        while (N > 0) {
            // 每次向一个方向，依次尝试右、下、左、上
            if (canRight) {
                for (int i = left; i <= right; i++) {
                    ints[top][i] = count++;
                }
                top++;
                canRight = false;
                canBottom = true;
            } else if (canBottom) {
                for (int i = top; i <= bottom; i++) {
                    ints[i][right] = count++;
                }
                right--;
                canBottom = false;
                canLeft = true;
            } else if (canLeft) {
                for (int i = right; i >= left; i--) {
                    ints[bottom][i] = count++;
                }
                bottom--;
                canLeft = false;
                canTop = true;
            } else if (canTop) {
                for (int i = bottom; i >= top; i--) {
                    ints[i][left] = count++;
                }
                left++;
                canTop = false;
                canRight = true;
            }
            time++;
            if (time % 4 == 0) {
                N--;
            }
        }
        // 输出结果
        for (int[] i : ints) {
            for (int j : i) {
                System.out.printf("%-4d", j);
            }
            System.out.println();
        }
    }
}
