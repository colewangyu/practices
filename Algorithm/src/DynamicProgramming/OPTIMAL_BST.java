package DynamicProgramming;

/**
 * Created by wy on 2016-06-24.
 */
public class OPTIMAL_BST {

    /**
     * 计算最优二叉搜索树的搜索期望
     *
     * @param p 关键字概率列表
     * @param q 伪关键字概率列表
     * @param n
     * @return
     */
    public double OptimalBST(double[] p, double[] q,int n) {
        double[][] e = new double[n+1][n+1];
        double[][] w = new double[n+1][n+1];
        double[][] root = new double[n][n];

        for(int i = 1; i <= n+1; i++) {
            e[i][i-1] = q[i-1];
            w[i][i-1] = q[i-1];
        }
        for(int l = 1; l <= n; l++) {
            for(int i = l; i <= n - l + 1; i++) {
                int j = i + l - 1;
                e[i][j] = Double.MAX_VALUE;
                w[i][j] = w[i][j-1] + p[j] + q[j];
                for(int r = i; r <= j; r++) {
                    double t = e[i][r-1] + e[r+1][j] + w[i][j];
                    if(t < e[i][j]) {
                        e[i][j] = t;
                        root[i][j] = r;
                    }
                }
            }
        }
        return e[1][n];
    }
}
