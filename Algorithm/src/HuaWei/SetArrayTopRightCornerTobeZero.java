package HuaWei;

import java.util.Scanner;

/**
 * Created by cole on 2016-08-16.
 */
public class SetArrayTopRightCornerTobeZero {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[][] a = new int[3][3];
        for(int i = 0; i < 3; i++)
            for(int j = 0; j < 3; j++) {
                a[i][j] =in.nextInt();
            }

        a = SetArrayTopRightCornerTobeZero(a);
        for(int i = 0; i < 3; i++)
            for(int j = 0; j < 3; j++) {
                System.out.print(a[i][j]);
            }
    }

    static int[][] SetArrayTopRightCornerTobeZero(int a[][]) {
        for(int i = 0; i < a.length; i++)
            for(int j = i; j < a[i].length; j++){
                a[i][j] = 0;
            }
        return a;
    }
}
