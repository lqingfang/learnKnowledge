package org.lqf.learn.leetCode.dynamic.guPiao;

public class maxProfit_714 {
    public static void main(String[] args) {

    }
    public int maxProfit(int[] prices, int fee) {
        int len = prices.length;
        if(len == 0) {
            return 0;
        }
        int[][] dp = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for(int i=1;i<len;i++) {
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i]-fee);
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);
        }
        return dp[len-1][0];
    }
    public int solution02(int[] prices, int fee) {
        int len = prices.length;
        if(len == 0) {
            return 0;
        }
        int dp_0 = 0;
        int dp_1 = -prices[0];
        for(int i=1;i<len;i++) {
            dp_0 = Math.max(dp_0,dp_1+prices[i]-fee);
            dp_1 = Math.max(dp_1,dp_0-prices[i]);
        }
        return dp_1;
    }
}
