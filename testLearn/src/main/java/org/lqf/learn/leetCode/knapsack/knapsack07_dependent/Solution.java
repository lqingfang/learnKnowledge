package org.lqf.learn.leetCode.knapsack.knapsack07_dependent;

/**
 * 有依赖的背包问题
 */
public class Solution {
    public static void main(String[] args) {
        int N = 5,V = 7;
        int[] v = {2,2,3,4,3};
        int[] w = {3,2,5,7,6};
        int[] p = {-1,1,1,2,2};
        System.out.println(dependent(N,V,v,w,p));//11
    }

    /**
     *
     * @param N 物品个数
     * @param V 体积
     * @param v 第i个物品体积
     * @param w 第i个物品价值
     * @param p 第i个物品依赖的物品编号
     * @return
     */
    static final int N = 110;
    static int n,m,idx;
    static int[] h = new int[N];
    static int[] e = new int[N];
    static int[] ne = new int[N];
    static int[] v = new int[N];
    static int[] w = new int[N];
    static int[][] f = new int[N][N];
    private static int dependent(int N,int V,int[] v,int[] w,int[] p) {
        int root = 0;
        for(int i=1;i<=n;i++) {
            if(p[i] == -1) {
                root = i;
            } else {
              add(p[i],i);
            }
        }
        dfs(root);
        return f[root][m];
//        int[][] dp = new int[N+1][V+1];
//        dp[0][0] = 0;
//        for(int i=1;i<N+1;i++) {
//            for(int j=0;j<V+1;j++) {
//
//            }
//        }
//        return dp[N][V];
    }
    private static void add(int x,int y) {
        e[idx] = y;
        ne[idx] = h[x];
        h[x] = idx++;
    }
    private static void dfs(int x) {
        for (int i = h[x]; i != -1; i = ne[i]) {
            int y = e[i];
            dfs(y);
            for (int j = m - v[x]; j >= 0; j--) {
                for (int k = 0; k <= j; k++) {
                    f[x][j] = Math.max(f[x][j], f[x][j - k] + f[y][k]);
                }
            }
        }
        for (int i = m; i >= v[x]; i--) {
            f[x][i] = f[x][i - v[x]] + w[x];
        }
        for (int i = 0; i < v[x]; i++) {
            f[x][i] = 0;
        }
    }
}
