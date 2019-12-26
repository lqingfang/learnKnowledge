package org.lqf.learn.leetCode.dynamic.uniquePathsWithObstacles_63;

public class Solution {
    public static void main(String[] args) {
        int[][] obstacleGrid = new int[][]{
                {0,0}
        };
        System.out.println(uniquePathsWithObstacles(obstacleGrid));
    }
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid[0][0]==1) {
            return 0;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for(int i=1;i<m;i++){
            dp[i][0] = (obstacleGrid[i][0] == 0 && dp[i-1][0]==1)? 1:0;
        }
        for(int j=1;j<n;j++){
            dp[0][j] = (obstacleGrid[0][j] == 0 && dp[0][j-1]==1)? 1:0;
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++) {
                if(obstacleGrid[i][j]!=1){
                    dp[i][j] = dp[i-1][j]+dp[i][j-1];
                }else {
                    dp[i][j] = 0;
                }
            }
        }
        return dp[m-1][n-1];
    }
}
