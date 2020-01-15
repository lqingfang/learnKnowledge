package org.lqf.learn.leetCode.dynamic.change_518;


public class Solution002 {
    public static void main(String[] args) {
        int[] coins = new int[]{
                1,2,5
        };
        int amount = 11;
        System.out.println(coinChange(coins,amount));
    }

    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        dp[0] = 1;
        for(int coin:coins) {
            for(int x= coin;x<amount+1;++x) {
                dp[x] = dp[x]+dp[x-coin];
            }

        }
        return dp[amount];
    }
}
