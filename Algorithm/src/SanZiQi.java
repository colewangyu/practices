import com.sun.org.apache.xml.internal.security.algorithms.implementations.IntegrityHmac;
import sun.security.util.Length;

import java.util.Scanner;

public class SanZiQi {
    final static int R = 10;  //行数
    final static int C = 10;  //列数
    final static int winLen = 5;  //连续长

    public static void main(String[] args) {
        while (true) {
            doGame();
        }
    }

    private static void doGame() {
        char[][] array = new char[R][C];
        Scanner scan;
        String tempStr;
        char tempChar;
        int totleX, totleO, totleD;
        boolean isFirstPerson;

        //=====接收输入,并验证数据,同时统计数据=====
        scan = new Scanner(System.in);

        totleX = 0;
        totleO = 0;
        totleD = 0;
        for (int i = 0; i < R; i++) {
            tempStr = scan.nextLine();
            for (int j = 0; j < C; j++) {
                tempChar = tempStr.charAt(j);
                //判断有效性
                if (tempChar == 'X') {
                    totleX++;
                } else if (tempChar == 'O') {
                    totleO++;
                } else if (tempChar == '.') {
                    totleD++;
                } else {
                    System.out.println("x");
                    return;
                }
                array[i][j] = tempChar;
            }
        }

        //====判断棋局是否合法
        if (Math.abs(totleO - totleX) > 1) {
            System.out.println("x");
            return;
        }

        //====判断当前行完棋的玩家=====
        if (totleO == totleX) {
            isFirstPerson = false;
        } else {
            isFirstPerson = true;
        }

        //====判断棋局结果=====
        tempChar = judge(array);

        //胜负已分
        if (tempChar == 'X') {
            //判断棋局有效性
            if(totleX - totleO < 0 ) {
                System.out.println("x");
            } else if (isFirstPerson) {
                System.out.println("1 won");
            } else {
                System.out.println("2 won");
            }
        } else if (tempChar == 'O') {
            //判断棋局有效性
            if(totleO - totleX < 0 ) {
                System.out.println("x");
            } else if(isFirstPerson) {
                System.out.println("1 won");
            } else {
                System.out.println("2 won");
            }
        }
        //胜负未分
        else if(tempChar == '.'){
            //判断平局
            if (totleO == totleX) {
                System.out.println("Draw");
            }
            //非平局,判断先后手
            else if (isFirstPerson) {
                System.out.println("2");
            } else {
                System.out.println("1");
            }
        }
        //出错
        else {
            System.out.println('x');
        }

    }

    private static char judge(char[][] array) {
        int tempLen;  //计算连续棋子的长度
        int count;  //统计符合规则的连续棋子的数量
        char winChar;  //获胜的字符
        char tempChar;  //当前比对的字符

        count = 0;
        winChar = '.';
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                tempChar = array[i][j];
                if(tempChar == '.')
                    continue;
                tempLen = 1;
                //判断向下的方向
                if ((i + winLen) <= R) {
                    for (int k = 1; k <= winLen - 1; k++) {
                        if (array[i][j] == array[i + k][j]) {
                            tempLen++;
                            continue;
                        } else {
                            tempLen = 1;
                            break;
                        }
                    }
                }
                if (tempLen == winLen) {
                    winChar = tempChar;
                    count++;
                }

                //判断向右的方向
                tempLen = 1;
                if ((j + winLen) <= C) {
                    for (int k = 1; k <= winLen - 1; k++) {
                        if (array[i][j] == array[i][j + k]) {
                            tempLen++;
                            continue;
                        } else {
                            tempLen = 1;
                            break;
                        }
                    }
                }
                if (tempLen == winLen) {
                    winChar = tempChar;
                    count++;
                }

                //判断向右下的方向
                tempLen = 1;
                if ((i + winLen) <= R && (j + winLen <= C)) {
                    for (int k = 1; k <= winLen - 1; k++) {
                        if (array[i][j] == array[i + k][j + k]) {
                            tempLen++;
                            continue;
                        } else {
                            tempLen = 1;
                            break;
                        }
                    }
                }
                if (tempLen == winLen) {
                    winChar = tempChar;
                    count++;
                }

                //判断向左下的方向
                tempLen = 1;
                if ((i + winLen) <= R && (j - winLen + 1 >= 0)) {
                    for (int k = 1; k <= winLen - 1; k++) {
                        if (array[i][j] == array[i + k][j - k]) {
                            tempLen++;
                            continue;
                        } else {
                            tempLen = 1;
                            break;
                        }
                    }
                }
                if (tempLen == winLen) {
                    winChar = tempChar;
                    count++;
                }
            }
        }
        if(count == 1)
            return winChar;
        else if(count == 0)
            return '.';
        else
            return 'x';
    }
}
