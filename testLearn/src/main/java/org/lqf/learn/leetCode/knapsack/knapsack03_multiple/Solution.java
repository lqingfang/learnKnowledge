package org.lqf.learn.leetCode.knapsack.knapsack03_multiple;

/**
 * 多重背包问题
 */
public class Solution {
    public static void main(String[] args) {
        int N = 4,V = 5;
        int[] s = {3,1,3,2};
        int[] v = {1,2,3,4};
        int[] w = {2,4,4,5};
        System.out.println(multiple02(N,V,s,v,w));
    }

    /**
     *
     * @param N 物品个数
     * @param V 物品总体积
     * @param s 第i个物品最多件数
     * @param v 第i个物品占用体积
     * @param w 第i个物品价值
     * @return
     */
    private static int multiple(int N,int V,int[] s,int[] v,int[] w) {
        int[][] dp = new int[N+1][V+1];
        dp[0][0] = 0;
        for(int i=1;i<N+1;i++) {
            for(int j=0;j<V+1;j++) {
                for(int k=0;k*v[i-1]<=j && k<=s[i-1];k++) {
                    dp[i][j] = Math.max(dp[i][j],dp[i-1][j-k*v[i-1]]+k*w[i-1]);
                }
            }
        }
        return dp[N][V];
    }
    /**
     *
     * @param N 物品个数
     * @param V 物品总体积
     * @param s 第i个物品最多件数
     * @param v 第i个物品占用体积
     * @param w 第i个物品价值
     * @return
     */
    private static int multiple02(int N,int V,int[] s,int[] v,int[] w) {
        int[] dp = new int[V+1];
        dp[0] = 0;
        for(int i=1;i<N+1;i++) {
            for(int j=0;j<V+1;j++) {
                for(int k=0;k*v[i-1]<=j && k<=s[i-1];k++) {
                    dp[j] = Math.max(dp[j],dp[j-k*v[i-1]]+k*w[i-1]);
                }
            }
        }
        return dp[V];
    }
}
