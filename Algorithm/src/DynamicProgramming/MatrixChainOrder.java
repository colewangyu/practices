package DynamicProgramming;

/**
 * 矩阵链最佳计算顺序
 * Created by wy on 2016-06-03.
 */
public class MatrixChainOrder {
    /**
     * 计算最佳的计算顺序需要花费的标量计算次数
     * 使用动态规划
     * 递归：
     * m[i,j]=0,when i = j
     * m[i,j]=min(m[i,k]+m[k+1,j]+p[i]*p[k+1]*p[j+1]),i<=k<j,i<j
     *
     * @param p 矩阵计算式子中个矩阵的大小的数组（A1A2A3对应p1p2p3p4，A1为p1*p2，A2为p2*p3，A3为p3*p4）
     * @return 最少的的标量计算次数，输入数组p为空会抛异常，数组p长度为0或1抛异常，数组p长度为2直接返回0；
     */
    public int matrixChainOrder(int[] p) {
        int n; //矩阵个数
        int[][] dp; //存储中间结果
        int[][] s; //分割方案，从第几个矩阵分开标量计算次数最小，第一个矩阵为0

        //验证输入
        if (p == null) throw new NullPointerException();
        //初始化矩阵个数
        n = p.length - 1;
        //验证数据是否合理，p的长度必须>=2，否则认定为异常数据
        if (n <= 0) throw new IllegalArgumentException();

        //初始化记录数组
        dp = new int[n][n];
        s = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 0;
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                s[i][i] = -1;
            }
        }

        //自底向上进行计算
        int t;// 暂存中间结果
        for (int gap = 1; gap < n; gap++) {
            for (int i = 0, j; i < n - gap; i++) {
                j = i + gap;
                for (int k = i; k < j; k++) {
                    t = dp[i][k] + dp[k + 1][j] + p[i] * p[k + 1] * p[j + 1];
                    if (t < dp[i][j]) {
                        dp[i][j] = t;
                        s[i][j] = k;
                    }
                }
            }
        }
        return dp[0][n - 1];
    }

    /**
     * 计算最佳的计算顺序需要花费的标量计算次数
     * 使用动态规划
     *
     * @param p 矩阵计算式子中个矩阵的大小的数组（A1A2A3对应p1p2p3p4，A1为p1*p2，A2为p2*p3，A3为p3*p4）
     * @return 标注了矩阵计算顺序的字符串
     */
    public String getMatrixChainOrder(int[] p) {
        int n; //矩阵个数
        int[][] dp; //存储中间结果
        int[][] s; //分割方案，从第几个矩阵分开标量计算次数最小，第一个矩阵为0
        int[] result; //计算顺序

        //验证输入
        if (p == null) throw new NullPointerException();
        //初始化矩阵个数
        n = p.length - 1;
        //验证数据是否合理
        if (n <= 0) throw new IllegalArgumentException();

        //初始化记录数组
        dp = new int[n][n];
        s = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 0;
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                s[i][i] = -1;
            }
        }

        //自底向上进行计算
        int t;// 暂存中间结果
        for (int gap = 1; gap < n; gap++) {
            for (int i = 0, j; i < n - gap; i++) {
                j = i + gap;
                for (int k = i; k < j; k++) {
                    t = dp[i][k] + dp[k + 1][j] + p[i] * p[k + 1] * p[j + 1];
                    if (t < dp[i][j]) {
                        dp[i][j] = t;
                        s[i][j] = k;
                    }
                }
            }
        }

        //计算最优计算顺序并返回
        return printOptimalParens(s, 0, n - 1, new StringBuffer());
    }

    private String printOptimalParens(int[][] s, int i, int j, StringBuffer sb) {
        if (i == j)
            sb.append("A" + i);
        else {
            sb.append("(");
            printOptimalParens(s, i, s[i][j], sb);
            printOptimalParens(s, s[i][j] + 1, j, sb);
            sb.append(")");
        }
        return sb.toString();
    }
}
