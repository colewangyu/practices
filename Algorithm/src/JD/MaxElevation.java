package JD;

import java.util.Scanner;

/**
 * Created by cole on 2016-09-05.
 */
public class MaxElevation {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            boolean flag = false;
            int days = in.nextInt();
            int dataCount = in.nextInt();
            int[] record = new int[days];
            int[] recordIndex = new int[dataCount];
            for(int i = 0; i < days; i++) {
                record[i] = Integer.MIN_VALUE;
            }
            for(int i = 0 ; i < dataCount; i++) {
                int index = in.nextInt() - 1;
                int value = in.nextInt();
                recordIndex[i] = index;
                record[index] = value;
            }
            int max = record[0];
            // 计算前面
            if(recordIndex[0] > 0) {
                int tmp = record[recordIndex[0]] + recordIndex[0];
                if(max < tmp)
                    max = tmp;
            }
            // 计算中间
            for(int i = 0 ; i < dataCount; i+=2) {
                int tmp = getMax(record,recordIndex[i],recordIndex[i+1]);
                if(tmp < 0) {
                    System.out.println("IMPOSSIBLE");
                    flag = true;
                    break;
                }
                if(max < tmp)
                    max = tmp;
            }
            if(flag)
                break;
            // 计算后面
            if(recordIndex[recordIndex.length - 1] < days) {
                int tmp = record[recordIndex[recordIndex.length - 1]] + (days - 1 - recordIndex[recordIndex.length - 1]);

                if(max < tmp)
                    max = tmp;
            }
            System.out.println(max);
        }
    }

    private static int getMax(int[] arr, int i1, int i2) {
        if(i1 > i2)
            return getMax(arr, i2, i1);
        int life = i2 - i1;
        int gap = Math.abs(arr[i2] - arr[i1]);
        int tmp =  (life - gap) >> 1;
        if(tmp < 0) return tmp;
        return (arr[i1] + tmp) > (arr[i2] + tmp) ? (arr[i1] + tmp) : (arr[i2] + tmp);
    }
}
