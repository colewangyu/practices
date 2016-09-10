package HuaWei;

import java.util.Scanner;

/**
 * Created by wy on 2016-09-10.
 * 输入窗口大小，帧大小，传递的内容。每个窗口包含若干帧，每个帧包含若干字符串
 * 输出最后一个窗口的大小(包含多少帧)，最后一帧的大小（包含多少字符）。
 * 输入：2,5,ABCD1EFGH2IJK
 * 输出：1,3
 */
public class WindowsAndFrame {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] strs = in.nextLine().split(",");
        int windowSize = Integer.valueOf(strs[0]);
        int frameLen = Integer.valueOf(strs[1]);
        if (windowSize == 0 || frameLen == 0)
            System.out.println("0,0");
        String str = strs[2];
        // 计算最后一个窗口所占字符串长度
        int tmp = str.length() % (windowSize * frameLen);
        if (tmp == 0) {
            System.out.println(windowSize + "," + frameLen);
            return;
        } else {
            int lastWindowSize = tmp / frameLen;
            lastWindowSize++;
            int lastFrameLen = str.length() % frameLen;
            if (lastFrameLen == 0)
                lastFrameLen = frameLen;
            System.out.println(lastWindowSize + "," + lastFrameLen);
        }
    }
}
