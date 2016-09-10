package HuaWei;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by wy on 2016-09-10.
 * 帮七个和尚安排挑水工作，每个和尚可以挑水的时间为一个一维数组，表示周一到周日是否能挑水（1表示能，0表示不能）
 * 输入（一个二维数组）：
 * 0 1 0 0 0 0 0
 * 1 0 0 0 0 0 0
 * 0 0 1 0 0 0 0
 * 0 0 0 1 0 0 0
 * 0 0 0 0 1 0 0
 * 0 0 0 0 0 1 0
 * 0 0 0 0 0 0 1
 * 输出（可以安排的总数，按大小输出各个安排：
 * 1
 * 2 1 3 4 5 6 7
 */
public class MakePlan {
    static ArrayList<StringBuffer> plans = new ArrayList<StringBuffer>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[][] arr = new int[7][7];
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                arr[i][j] = in.nextInt();
            }
        }
        makePlan(arr, 0, new StringBuffer());
        System.out.println(plans.size());
        for (int i = 0; i < plans.size(); i++) {
            String s = plans.get(i).deleteCharAt(plans.get(i).length() - 1).toString();
            System.out.println(s);
        }
    }

    static void makePlan(int[][] arr, int curDay, StringBuffer sb) {
        if (curDay == 7) {
            plans.add(sb);
        } else {
            for (int i = 0; i < 7; i++) {
                if (arr[i][curDay] == 1 && sb.indexOf(String.valueOf(i + 1)) == -1) {
                    StringBuffer sbTmp = new StringBuffer(sb);
                    sbTmp.append((i + 1) + " ");
                    makePlan(arr, curDay + 1, sbTmp);
                }
            }
        }
    }
}
