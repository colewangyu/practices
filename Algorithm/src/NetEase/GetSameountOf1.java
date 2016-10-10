package NetEase;

import java.util.Scanner;

/**
 * Created by cole on 2016-09-23.
 * 输出与输入数二进制中1的数量相同且大于输入数的数.
 */
public class GetSameountOf1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int indexFirst1 = getIndexOfFirst1(N);
        N = N - (int)Math.pow(2, indexFirst1) + (int)Math.pow(2, indexFirst1 + 1);
        System.out.println(N);
    }

    private static int getIndexOfFirst1(int num) {
        int index = 0;
        while(true) {
            if ((num & 1) == 1 && (num & 2) == 0) {
                return index;
            } else {
                index++;
                num = num >> 1;
            }
        }
    }
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int N = in.nextInt();
//        int weight = getWeight(N);
//        while(true) {
//            N++;
//            if(weight == getWeight(N)) {
//                System.out.println(N);
//                break;
//            }
//        }
//    }
//
//    private static int getWeight(int num) {
//        int count = 0;
//        while(num > 0) {
//            count++;
//            num = (num - 1) & num;
//        }
//        return count;
//    }
}
