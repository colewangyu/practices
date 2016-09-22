package 猪八戒;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by cole on 2016-09-22.
 * <p/>
 * 输入多个正整数,通过拼接组合成一个最大的正整数.
 * 有多组测试样例，每组测试样例包含两行，第一行为一个整数N（N<=100），第二行包含N个数(每个数不超过1000，空格分开)。
 * 样例输入:
 * 2
 * 12 121
 * 3
 * 11 21 31
 * 样例输出:
 * 12121
 * 312111
 */
public class AppendMaxInteger {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N;
        String[] arr;
        MyString[] myArr;
        while (in.hasNextInt()) {
            N = in.nextInt();
            myArr = new MyString[N];
            for (int i = 0; i < N; i++) {
                myArr[i] = new MyString(in.nextInt());
            }
            Arrays.sort(myArr);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < myArr.length; i++) {
                sb.append(myArr[i].toString());
            }
            System.out.println(sb.toString());
        }
    }
}

class MyString implements Comparable<MyString> {
    private String s;

    public MyString(int i) {
        this.s = String.valueOf(i);
    }

    @Override
    public int compareTo(MyString o) {
        int lenThis = this.s.length();
        int lenO = o.s.length();
        int lenMax, lenMin;
        if(lenO > lenThis) {
            lenMax = lenO;
            lenMin = lenThis;
        } else {
            lenMax = lenThis;
            lenMin = lenO;
        }
        for (int i = 0; i < lenMax; i++) {
            if (this.s.charAt(i % lenThis) > o.s.charAt(i % lenO))
                return -1;
            if (this.s.charAt(i % lenThis) < o.s.charAt(i % lenO))
                return 1;
        }
        if(lenMin == lenO) {
            if(this.s.charAt(0) > o.s.charAt(lenMin - 1))
                return -1;
            else
                return 1;
        } else {
            if(this.s.charAt(lenMin - 1) > o.s.charAt(0))
                return -1;
            else
                return 1;
        }
    }

    @Override
    public String toString() {
        return s;
    }
}
