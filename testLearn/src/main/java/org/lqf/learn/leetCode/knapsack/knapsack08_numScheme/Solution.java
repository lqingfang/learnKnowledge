package org.lqf.learn.leetCode.knapsack.knapsack08_numScheme;

/**
 * 背包问题求方案数
 */
public class Solution {
    public static void main(String[] args) {
        int N = 4,V= 5;
        int[] v = {1,2,3,4};
        int[] w = {2,4,4,6};
        System.out.println(numScheme(N,V,v,w));
    }
    private static int numScheme(int N,int V,int[] v,int[] w) {
        int[][] dp = new int[N+1][V+1];
        dp[0][0] = 0;
        for(int i=1;i<N+1;i++) {
            for(int j=0;j<V+1;j++) {
                if(j>=v[i-1]) {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-v[i-1]]+w[i-1]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        int count = 0;
        for(int i=1;i<N+1;i++) {
            for(int j=0;j<V+1;j++) {
                if(dp[i][j] == dp[N][V]) {
                    count++;
                }
            }
        }
        return count;
    }

}
