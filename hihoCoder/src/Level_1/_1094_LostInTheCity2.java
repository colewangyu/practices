package Level_1;

import java.util.Scanner;

/**
 * Created by cole on 10/19/15.
 * 是一个更好的解决办法
 */
public class _1094_LostInTheCity2 {
    public static void main(String[] args) {
        final short row, column;  //地图的长宽
        char[][] map;  //地图
        char[][] position;  //标识Little Hi位置的矩阵
        String tempLine;  //暂存输入的一行数据


        Scanner scanner = new Scanner(System.in);
        row = scanner.nextShort();
        column = scanner.nextShort();

        map = new char[row][column];
        scanner.nextLine();
        for (short i = 0; i < row; i++) {
            //获取一行数据
            tempLine = scanner.nextLine();
            //将一行输入录入map
            for (short j = 0; j < column; j++) {
                map[i][j] = tempLine.charAt(j);
            }
        }
        position = new char[3][3];
        for (short i = 0; i < 3; i++) {
            //获取一行数据
            tempLine = scanner.nextLine();
            //将一行输入录入map
            for (short j = 0; j < 3; j++) {
                position[i][j] = tempLine.charAt(j);
            }
        }
        char centerChar = position[1][1];

        char[][] position90 = rotate90(position);
        char[][] position180 = rotate90(position90);
        char[][] position270 = rotate90(position180);

        for (short i = 1; i < row - 1; i++) {
            for (short j = 1; j < column - 1; j++) {
                //如果中心位置匹配，就进行区域匹配
                if (centerChar == map[i][j] && (isMatched(map, position, i, j) || isMatched(map, position90, i, j) ||
                        isMatched(map, position180, i, j) || isMatched(map, position270, i, j))) {
                    System.out.println((i + 1) + " " + (j + 1));
                }
            }
        }
    }

    //顺时针旋转90度
    public static char[][] rotate90(char[][] position) {
        char[][] rotate90 = new char[3][3];

        for (short i = 0; i < 3; i++)
            for (short j = 0; j < 3; j++) {
                rotate90[i][j] = position[j][2 - i];
            }

        return rotate90;
    }


    public static boolean isMatched(char[][] map, char[][] position, short map_x, short map_y) {

        for (short i = 0; i < 3; i++) {
            for (short j = 0; j < 3; j++) {
                if (position[i][j] != map[map_x + i - 1][map_y + j - 1]) {
                    return false;
                }
            }
        }
        return true;

    }
}


