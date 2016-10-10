package NetEase;

import java.util.Scanner;

/**
 * Created by cole on 2016-09-23.
 * 输入三个数A\B\C,获取A到B(包含A\B)中各位数和(各个位相加的和)与C绝对值差最小的数.
 */
public class BitSum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int A = in.nextInt();
        int B = in.nextInt();
        int C = in.nextInt();

        int targetBitSum = bitSum(C);
        int min = Math.abs(targetBitSum - bitSum(A));
        int minNum = A;
        for(int i = A + 1; i <= B; i++) {
            if(min == 0)
                break;
            int tmp = bitSum(i);
            if(Math.abs(targetBitSum - tmp) < min) {
                min = Math.abs(targetBitSum - tmp);
                minNum = i;
            }
        }
        System.out.println(minNum);
    }

    private static int bitSum(int num) {
        String s = String.valueOf(num);
        int sum = 0;
        for(int i = 0 ; i < s.length(); i++ ) {
            sum += s.charAt(i) - 48;
        }
        return sum;
    }
}
