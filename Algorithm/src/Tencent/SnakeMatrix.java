package Tencent;

import java.util.Scanner;

/**
 * Created by wy on 2016-09-01.
<<<<<<< be832f4ee592d5ce208b317a16f68159a812ffd5
 *
=======
 * <p/>
>>>>>>> 腾讯笔试算法题
 * 顺时针蛇形数组
 */
public class SnakeMatrix {
    private static int count = 0;
    private static int row = 0, col = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[][] ints = new int[N][N];
        int[] directions = new int[]{N - 1, N - 1, 0, 0};
        int direction = 1;
        boolean flag = false;
        while (true) {
            switch (direction) {
                case 1:
                    if (col <= directions[0]) {
                        printToRight(ints, directions);
                        direction = 2;
                    } else {
                        flag = true;
                    }
                    break;
                case 2:
                    if (row <= directions[1]) {
                        printToBottom(ints, directions);
                        direction = 3;
                    } else {
                        flag = true;
                    }
                    break;
                case 3:
                    if (col >= directions[2]) {
                        printToLeft(ints, directions);
                        direction = 4;
                    } else {
                        flag = true;
                    }
                    break;
                case 4:
                    if (row >= directions[3]) {
                        printToTop(ints, directions);
                        direction = 1;
                    } else {
                        flag = true;
                    }
                    break;
            }
            if (flag)
                break;
        }
        for (int[] i : ints) {
            for (int j : i) {
                System.out.printf("%-4s", j + " ");
            }
            System.out.println();
        }
    }

    // 向右输出
    private static void printToRight(int[][] ints, int[] directions) {
        for (; col <= directions[0]; col++) {
            count++;
            ints[row][col] = count;
        }
        col--;
        row++;
        directions[3]++;
    }

    // 向下输出
    private static void printToBottom(int[][] ints, int[] directions) {
        for (; row <= directions[1]; row++) {
            count++;
            ints[row][col] = count;
        }
        row--;
        col--;
        directions[0]--;
    }

    // 向左输出
    private static void printToLeft(int[][] ints, int[] directions) {
        for (; col >= directions[2]; col--) {
            count++;
            ints[row][col] = count;
        }
        col++;
        row--;
        directions[1]--;
    }

    // 向上输出
    private static void printToTop(int[][] ints, int[] directions) {
        for (; row >= directions[3]; row--) {
            count++;
            ints[row][col] = count;
        }
        row++;
        col++;
        directions[2]++;
    }
}
