package org.lqf.learn.leetCode.knapsack.knapsack04_mix;

/**
 * 混合背包问题
 */
public class Solution {
    public static void main(String[] args) {
        int N = 4,V = 5;
        int[] s = {-1,1,0,2};
        int[] v = {1,2,3,4};
        int[] w = {2,4,4,5};
        System.out.println(mix02(N,V,s,v,w));
    }

    /**
     *
     * @param N
     * @param V
     * @param s -1:只用一次  0:无限次  >0:s[i]次
     * @param v
     * @param w
     * @return
     */
    private static int mix(int N,int V,int[] s,int[] v,int[] w) {
        int[][] dp = new int[N+1][V+1];
        dp[0][0] = 0;
        for(int i=1;i<N+1;i++) {
            for(int j=0;j<V+1;j++) {
                if(s[i-1]==-1 && j>v[i-1]) {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-v[i-1]]+w[i-1]);
                }else if(s[i-1]>0) {
                    for(int k=0;k*v[i-1]<=j && k<=s[i-1];k++) {
                        dp[i][j] = Math.max(dp[i][j],dp[i-1][j-k*v[i-1]]+k*w[i-1]);
                    }
                }else if(s[i-1] ==0) {
                    for(int k=0;k*v[i-1]<=j;k++) {
                        dp[i][j] = Math.max(dp[i][j],dp[i-1][j-k*v[i-1]]+k*w[i-1]);
                    }
                }
            }
        }
        return dp[N][V];
    }
    private static int mix02(int N,int V,int[] s,int[] v,int[] w) {
        int[] dp = new int[V+1];
        dp[0] = 0;
        for(int i=1;i<N+1;i++) {
            for(int j=0;j<V+1;j++) {
                if(s[i-1]==-1 && j>v[i-1]) {
                    dp[j] = Math.max(dp[j],dp[j-v[i-1]]+w[i-1]);
                }else if(s[i-1]>0) {
                    for(int k=0;k*v[i-1]<=j && k<=s[i-1];k++) {
                        dp[j] = Math.max(dp[j],dp[j-k*v[i-1]]+k*w[i-1]);
                    }
                }else if(s[i-1] ==0) {
                    for(int k=0;k*v[i-1]<=j;k++) {
                        dp[j] = Math.max(dp[j],dp[j-k*v[i-1]]+k*w[i-1]);
                    }
                }
            }
        }
        return dp[V];
    }
}
