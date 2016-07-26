package DynamicProgramming;

import java.util.Arrays;

/**
 * Created by wy on 2016-06-12.
 */
public class LCS {
    /**
     * 计算两个字符串的最长公共子序列的长度
     * 使用动态规划，自底向上的方法
     * O(n^2)
     *
     * @param X 字符串1
     * @param Y 字符串2
     * @return 最长公共子序列的长度
     */
    public int LCS(char[] X, char[] Y) {
        //验证输入有效性
        if (X == null || Y == null) {
            throw new NullPointerException();
        }
        //声明变量
        int dp[][]; //暂存中间计算结果，避免重复计算
        int lenX; //X的长度
        int lenY; //Y的长度
        //初始化变量
        lenX = X.length;
        lenY = Y.length;
        //初始化多一个长度，便于计算
        dp = new int[lenX + 1][lenY + 1];
        //设置底层的值
        for (int i = 0; i <= lenX; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i <= lenY; i++) {
            dp[0][i] = 0;
        }
        //执行遍历计算LCS
        for (int i = 1; i <= lenX; i++) {
            for (int j = 1; j <= lenY; j++) {
                if (X[i - 1] == Y[j - 1])
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[lenX][lenY];
    }

    /**
     * 计算两个字符串的最长公共子序列的长度
     * 使用递归的方式（暴力法）
     * O(2^n)
     *
     * @param X 字符串1
     * @param Y 字符串2
     * @return 最长公共子序列的长度
     */
    public int LCS_Recusion(char[] X, char[] Y) {
        //判断数据有效性
        if (X == null || Y == null) {
            throw new NullPointerException();
        }
        //递归计算LCS长度
        return computeLCS_Recusion(X, Y, X.length - 1, Y.length - 1);
    }

    /**
     * 计算两个字符串的最长公共子序列的长度
     * 使用动态规划，自底向上的方法
     * O(n^2)
     *
     * @param X 字符串1
     * @param Y 字符串2
     * @return 最长公共子序列
     */
    public String getLCS(char[] X, char[] Y) {
        //验证输入有效性
        if (X == null || Y == null) {
            throw new NullPointerException();
        }
        //声明变量
        int dp[][]; //暂存中间计算结果，避免重复计算
        int b[][]; //记录转移方向
        int lenX; //X的长度
        int lenY; //Y的长度
        //初始化变量
        lenX = X.length;
        lenY = Y.length;
        //初始化多一个长度，便于计算
        dp = new int[lenX + 1][lenY + 1];
        b = new int[lenX + 1][lenY + 1];
        //设置底层的值
        for (int i = 0; i <= lenX; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i <= lenY; i++) {
            dp[0][i] = 0;
        }
        //执行遍历计算LCS
        for (int i = 1; i <= lenX; i++) {
            for (int j = 1; j <= lenY; j++) {
                if (X[i - 1] == Y[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    b[i][j] = 11;
                } else if (dp[i - 1][j] >= dp[i][j - 1]) {
                    dp[i][j] = dp[i - 1][j];
                    b[i][j] = 10;
                } else {
                    dp[i][j] = dp[i][j - 1];
                    b[i][j] = 1;
                }
            }
        }

        //遍历计算最长公共子序列
        StringBuffer s;
        int i,j;

        s = new StringBuffer();
        i = lenX;
        j = lenY;

        while(true) {
            if(i == 0 || j == 0)
                break;
            if (b[i][j] == 11) {
                s.insert(0, X[i - 1]);
                i--;
                j--;
            } else if (b[i][j] == 10) {
                i--;
            } else if (b[i][j] == 1) {
                j--;
            }
        }
        return s.toString();
    }

    /**
     * 递归计算LCS长度
     *
     * @param X 字符串1
     * @param Y 字符串2
     * @param i 字符串1的计算长度，[0,i]
     * @param j 字符串2的计算长度，[0,j]
     * @return 最长公共子序列的长度
     */
    private int computeLCS_Recusion(char[] X, char[] Y, int i, int j) {
        //判断是否相等
        if (X[i] == Y[j]) {
            //处理跳出递归的情况：任意一遍搜索完毕，且找到公共字符，否则进行递归
            if (i == 0 || j == 0) {
                return 1;
            } else {
                return computeLCS_Recusion(X, Y, i - 1, j - 1) + 1;
            }
        } else {
            //处理跳出递归的情况：两个字符串都遍历完成，则跳出递归
            if (i == 0 && j == 0) {
                return 0;
            } else if (i == 0) {
                //如果字符串1遍历完成，则仅遍历字符串2
                return computeLCS_Recusion(X, Y, i, j - 1);
            } else if (j == 0) {
                //如果字符串2遍历完成，则仅遍历字符串1
                return computeLCS_Recusion(X, Y, i - 1, j);
            } else {
                //如果两个字符串皆未遍历完成，则遍历两者，找出最大的一个。
                return Math.max(computeLCS_Recusion(X, Y, i - 1, j), computeLCS_Recusion(X, Y, i, j - 1));
            }
        }
    }

}
