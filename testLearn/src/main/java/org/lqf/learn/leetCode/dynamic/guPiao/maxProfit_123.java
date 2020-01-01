package org.lqf.learn.leetCode.dynamic.guPiao;

/**
 * dp[i][k][0] = max(dp[i-1][k][0],dp[i-1][k][1]+price[i])
 * dp[i][k][1] = max(dp[i-1][k][1],dp[i-1][k-1][0]-price[i])
 */
public class maxProfit_123 {
    public static void main(String[] args) {

    }
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if(len == 0) {
            return 0;
        }
        int[][][] dp = new int[len][3][2];

        for(int i=0;i<len;i++){
            for(int j=2;j>0;j--) {
                if(i==0) {
                    dp[i][j][0] = 0;
                    dp[i][j][1] = -prices[i];
                    continue;
                }
                dp[i][j][0] = Math.max(dp[i-1][j][0],dp[i-1][j][1]+prices[i]);
                dp[i][j][1] = Math.max(dp[i-1][j][1],dp[i-1][j-1][0]-prices[i]);
            }
        }
        return dp[len-1][2][0];
    }
}
