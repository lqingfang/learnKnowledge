package org.lqf.learn.leetCode.dynamic.uniquePaths_62;

public class Solution {
    public static void main(String[] args) {

    }
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++) {
                if(i==0 && j<n) {
                    dp[0][j] = 1;
                }else if(j==0 && i<m) {
                    dp[i][0] = 1;
                }else {
                    dp[i][j] = dp[i-1][j]+dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }
}
