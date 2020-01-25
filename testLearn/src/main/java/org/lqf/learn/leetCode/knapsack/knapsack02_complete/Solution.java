package org.lqf.learn.leetCode.knapsack.knapsack02_complete;

/**
 * 完全背包问题：
 *
 *  商品数量：N
 *  容量：V
 *
 *  每件商品的容量：weight
 *  每件商品的价值：value
 *
 *  dp[i][j] 表示第i个商品，容量为j的总价值对大值
 *
 *  求将哪些物品放入背包，可使价值最大，不限商品放入次数
 *
 */
public class Solution {
    public static void main(String[] args) {
        int N = 4,V=5;
        int[] v = {1,2,3,4};
        int[] w = {2,4,4,5};
        System.out.println(complete02(N,V,v,w));
    }
    private static int complete(int N,int V,int[] v,int[] w) {
        int[][] dp = new int[N+1][V+1];
        dp[0][0] = 0;
        for(int i=1;i<N+1;i++) {
            for(int j=1;j<V+1;j++) {
               for(int k=0;k*v[i-1]<=j;k++) {
                   dp[i][j] = Math.max(dp[i][j],dp[i-1][j-k*v[i-1]]+k*w[i-1]);
               }
            }
        }
        return dp[N][V];
    }
    private static int complete02(int N,int V,int[] v,int[] w) {
        int[] dp = new int[V+1];
        dp[0] = 0;
        for(int i=1;i<N+1;i++) {
            for(int j=1;j<V+1;j++) {
                for(int k=0;k*v[i-1]<=j;k++) {
                    dp[j] = Math.max(dp[j],dp[j-k*v[i-1]]+k*w[i-1]);
                }
            }
        }
        return dp[V];
    }
}
