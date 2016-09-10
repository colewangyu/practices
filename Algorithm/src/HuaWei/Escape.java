package HuaWei;

import java.util.Scanner;

/**
 * Created by wy on 2016-09-10.
 * 从洞穴逃生，法力值M，距离洞口S，坍塌时间T，10点M可以前进60M/s，普通速度17m/s，不使用法力恢复4点M，判断是否能逃生。
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
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 法力值
        int M = in.nextInt();
        // 距洞口距离
        int S = in.nextInt();
        // 坍塌时间
        int T = in.nextInt();

        int countTime = 0;
        int countDistance = 0;
        for (int i = T; i > 0 && S > 0; i--) {
            countTime++;
            if (M / 10 > 0) {
                M -= 10;
                S -= 60;
                countDistance += 60;
            } else {
                M += 4;
                S -= 17;
                countDistance += 17;
            }
        }
        if (S <= 0)
            System.out.println("Yes " + countTime);
        else
            System.out.println("No " + countDistance);
    }
}
