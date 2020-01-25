package org.lqf.learn.leetCode.knapsack.knapsack05_dimensional;

/**
 * 二维费用的背包问题
 有 N
 件物品和一个容量是 V
 的背包，背包能承受的最大重量是 M
 。

 每件物品只能用一次。体积是 vi
 ，重量是 mi
 ，价值是 wi
 。

 求解将哪些物品装入背包，可使物品总体积不超过背包容量，总重量不超过背包可承受的最大重量，且价值总和最大。
 输出最大价值。
 */
public class Solution {
    public static void main(String[] args) {
        int N=4,V=5,M=6;
        int[] v = new int[] {1,2,3,4};
        int[] m = new int[] {2,4,4,5};
        int[] w = new int[] {3,4,5,6};
        System.out.println(dimensional02(N,V,M,v,m,w));
    }

    /**
     *
     * @param N 物品数
     * @param V 体积数
     * @param M 承受的最大重量
     * @param v 每个物品的体积
     * @param m 每个物品的重量
     * @param w 每个物品的价值
     * @return
     */
    private static int dimensional(int N,int V,int M,int[] v,int[] m,int[] w){
        int[][][] dp = new int[N+1][V+1][M+1];
        dp[0][0][0] = 0;
        for(int i=1;i<N+1;i++){
            for(int j=1;j<V+1;j++) {
                for(int k=1;k<M+1;k++) {
                    if(j<v[i-1] || k<m[i-1]) {
                        dp[i][j][k] = dp[i-1][j][k];
                    } else {
                        dp[i][j][k] = Math.max(dp[i-1][j][k],dp[i-1][j-v[i-1]][k-m[i-1]]+w[i-1]);
                    }
                }
            }
        }
        return dp[N][V][M];
    }
    /**
     *
     * @param N 物品数
     * @param V 体积数
     * @param M 承受的最大重量
     * @param v 每个物品的体积
     * @param m 每个物品的重量
     * @param w 每个物品的价值
     * @return
     */
    private static int dimensional02(int N,int V,int M,int[] v,int[] m,int[] w){
        int[][] dp = new int[V+1][M+1];
        dp[0][0] = 0;
        for(int i=1;i<N+1;i++){
            for(int j=V;j>0;j--) {
                for(int k=1;k<M+1;k++) {
                    if(j<v[i-1] || k<m[i-1]) {
                        dp[j][k] = dp[j-1][k];
                    } else {
                        dp[j][k] = Math.max(dp[j][k],dp[j-v[i-1]][k-m[i-1]]+w[i-1]);
                    }
                }
            }
        }
        return dp[V][M];
    }
}
