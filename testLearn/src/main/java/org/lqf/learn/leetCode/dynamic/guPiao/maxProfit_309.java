package org.lqf.learn.leetCode.dynamic.guPiao;

/**
 * dp[i][k][0] = max(dp[i-1][k][0],dp[i-1][k][1]+price[i])
 * dp[i][k][1] = max(dp[i-1][k][1],dp[i-1][k][0]-price[i])
 */
public class maxProfit_309 {
    public static void main(String[] args) {

    }
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if(len == 0) {
            return 0;
        }
        int[][] dp = new int[len][2];

        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for(int i=1;i<len;i++) {
            if(i==1) {
                dp[i][0] = Math.max(0,-prices[0]+prices[1]);
                dp[i][1] = Math.max(-prices[0],-prices[1]);
                continue;
            }
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            dp[i][1] = Math.max(dp[i-1][1],dp[i-2][0]-prices[i]);
        }
        return dp[len-1][0];
    }

    public int solution02(int[] prices) {
        int len = prices.length;
        if(len == 0) {
            return 0;
        }

        int dp_0 = 0;
        int dp_1 = -prices[0];
        int dp_pre = 0;
        for(int i=1;i<len;i++) {
            int temp = dp_0;
            dp_0 = Math.max(dp_0,dp_1+prices[i]);
            dp_1 = Math.max(dp_1,dp_pre-prices[i]);
            dp_pre = temp;
        }
        return dp_0;
    }
}
