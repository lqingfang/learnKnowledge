package org.lqf.learn.leetCode.knapsack.knapsack06_group;

/**
 * 分组背包问题
 */
public class Solution {
    public static void main(String[] args) {
        int N=3,V=5;
        int[][] v = new int[][] {
                {1,2},
                {3},
                {4}
        };
        int[][] w = new int[][] {
                {2,4},
                {4},
                {5}
        };
        System.out.println(group02(N,V,v,w));
    }
    private static int group(int N,int V,int[][] v,int[][] w) {
        int[][] dp = new int[N+1][V+1];
        dp[0][0] = 0;

        for(int i=1;i<N+1;i++) {
            for(int j=1;j<V+1;j++) {
                for(int k=0;k<v[i-1].length;k++) {
                    if(j>=v[i-1][k]) {
                        dp[i][j] = Math.max(dp[i][j],dp[i-1][j-v[i-1][k]]+w[i-1][k]);

                    }
                }

            }
        }
        int res = 0;
        for(int i=0;i<N+1;i++) {
            for(int j=0;j<V+1;j++) {
                res = Math.max(res,dp[i][j]);
            }
        }
        return res;
    }
    private static int group02(int N,int V,int[][] v,int[][] w) {
        int[] dp = new int[V+1];
        dp[0] = 0;
        for(int i=1;i<N+1;i++) {
            for(int j=V;j>0;j--) {
                for(int k=0;k<v[i-1].length;k++) {
                    if(j>=v[i-1][k]) {
                        dp[j] = Math.max(dp[j],dp[j-v[i-1][k]]+w[i-1][k]);

                    }
                }

            }
        }

        return dp[V];
    }
}
