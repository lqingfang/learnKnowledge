package org.lqf.learn.leetCode.dynamic.coinChange_322;

import java.util.Arrays;

public class Solution003 {
    public static void main(String[] args) {
        int[] coins = new int[]{
                1,2,5
        };
        int amount = 11;
        System.out.println(coinChange(coins,amount));
    }

    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0]=0;
        for(int i=1;i<amount+1;i++) {
            for(int coin :coins) {
                if(i>=coin) {
                    dp[i] = Math.min(dp[i-coin]+1,dp[i]);
                }
            }
        }
        return dp[amount]<amount+1?dp[amount]:-1;
    }
}
