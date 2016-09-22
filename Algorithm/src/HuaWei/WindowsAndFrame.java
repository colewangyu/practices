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
        doWindowsAndFrame();
    }

    public static void doWindowsAndFrame() {
        Scanner in = new Scanner(System.in);
        String[] strs = in.nextLine().split(",");
        int windowSize = Integer.valueOf(strs[0]);
        int frameLen = Integer.valueOf(strs[1]);
        if (windowSize == 0 || frameLen == 0)
            System.out.println("0,0");
        String str = strs[2];
        int lastWindowSize;
        int lastFrameSize;
        // 计算最后一个窗口的字符长度
        lastWindowSize = str.length() % (windowSize * frameLen);
        if(lastWindowSize == 0) {
            // 刚好除尽的情况
            lastWindowSize = windowSize;
            lastFrameSize = frameLen;
        } else {
            // 计算最后一帧的大小
            lastFrameSize = lastWindowSize % frameLen;
            // 刚好除尽的情况
            if(lastFrameSize == 0) {
                lastFrameSize = frameLen;
            }
            lastWindowSize = lastWindowSize / frameLen + 1;
        }
        System.out.println(lastWindowSize + "," + lastFrameSize);
    }
}
