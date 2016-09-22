package HuaWei;

import java.util.Scanner;

/**
 * Created by wy on 2016-09-10.
 * 从洞穴逃生，法力值M，距离洞口S，坍塌时间T，10点M可以前进60M/s，普通速度17m/s，原地休息法力恢复4点M/s，判断是否能逃生。
 * <p>
 * 输出格式：
 * Yes 逃出洞穴所用的最短时间
 * 或
 * No 在洞穴塌陷前能逃跑的最远距离
 *
 * 样例输入:
 * 10
 * 50
 * 5
 * 样例输出: Yes 1
 */
public class Escape {
    static int maxDistance = 0;
    public static void main(String[] args) {
        doEscape();
    }

    public static void doEscape() {
        Scanner in = new Scanner(System.in);
        // 法力值
        int M = in.nextInt();
        // 距洞口距离
        int S = in.nextInt();
        // 坍塌时间
        int T = in.nextInt();

        int countTime = 0;
        int countDistance = 0;
        int timeLeft = action(M,S,T,countDistance);
        if (timeLeft >= 0)
            System.out.println("Yes " + (T - timeLeft));
        else
            System.out.println("No " + maxDistance);
    }

    private static int action(int M, int S, int T, int countDistance) {
        if(S <= 0) {
            return T;
        }
        if(T <= 0) {
            maxDistance = countDistance > maxDistance ? countDistance : maxDistance;
            return T - 1;
        }
        if(M / 10 >= 1) {
            // 使用魔法
            return action(M - 10, S - 60, T - 1, countDistance + 60);
        } else {
            // 选择等待
            int t1 = action(M + 4, S, T - 1, countDistance);
            // 选择跑步
            int t2 = action(M, S - 17, T -1, countDistance + 17);
            return t1 > t2 ? t1 : t2;
        }
    }
}
