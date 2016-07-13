package DynamicProgramming;

/**
 * Created by wy on 2016-06-01.
 * 切割钢条问题
 */
public class CutRod {

    /**
     * 切割钢条问题（问题来源于《算法导论》15.1节）
     * 采用动态规划的方法求解一个最优解，此处使用自顶向下的方法，
     *
     * @param p 钢条价格的数组
     * @param n 待切割钢条的长度
     * @return 一个最佳收益的值
     */
    public int cutRodTopDown(int[] p, int n) {
        //验证数据有效性
        if (p == null || n < 0) {
            throw new IllegalArgumentException();
        }
        //初始化记录数组
        int[] dp = new int[n];
        for (int i = 0; i < dp.length; i++)
            dp[i] = -1;
        return computeCutRodTopDown(p, n, dp);
    }

    /**
     * 切割钢条问题（问题来源于《算法导论》15.1节）
     * 采用动态规划的方法求解一个最优解。使用 <b>自底向上</b> 的方法计算最优解
     *
     * @param p 钢条价格的数组
     * @param n 待切割钢条的长度
     * @return 一个最佳收益的值
     */
    public int cutRodBottomUp(int[] p, int n) {
        //判断输入参数有效性
        if(p == null || n < 0)
            throw new IllegalArgumentException();
        //设置辅助记录数组并初始化
        int[] dp = new int[n + 1];
        for(int i = 0; i < dp.length; i++) {
            dp[i] = -1;
        }
        //设置最底部的值
        dp[0] = 0;
        //自底向上处理
        int q; //暂存中间结果
        for(int j = 1; j < dp.length; j++) {
            q = 0;
            for(int i = 1; i <= p.length && i <= j; i++) {
                q = Math.max(q, p[i - 1] + dp[j - i]);
            }
            dp[j] = q;
        }
        return dp[n];
    }

    /**
     * 动态规划自顶向下计算最优解
     *
     * @param p 钢条价格的数组
     * @param n 待切割钢条的长度
     * @param r 辅助记录数组，长度为n
     * @return 一个最佳收益的值
     */
    private int computeCutRodTopDown(int[] p, int n, int[] r) {
        int q;  //记录返回值
        if (n == 1) {
            //如果钢条长度为1则不可分割，返回对应值
            return p[0];
        } else if(n == 0) {
            //如果钢条长度为0，返回0
            return 0;
        } else {
            //如果已经计算过，则直接返回
            if (r[n - 1] > 0)
                return r[n - 1];
            //钢条长度不为0，分解子问题
            q = -1;
            for (int i = 1; i <= n; i++) {
                q = Math.max(q, p[i - 1] + computeCutRodTopDown(p, n - i, r));
            }
        }
        r[n - 1] = q;
        return q;
    }
}
