package Level_1;

import java.util.Scanner;

/**
 * Created by home on 2015-10-16.
 */
public class _1000_AaddB {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        byte a,b;
        while(in.hasNext()) {
            a = in.nextByte();
            b = in.nextByte();
            System.out.println(a + b);
        }
    }
}
