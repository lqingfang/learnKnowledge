package org.lqf.learn.leetCode.dynamic.coinChange_322;

import java.util.Arrays;

/**
 * 动态规划-自下而上
 */
public class Solution03 {
    public static void main(String[] args) {
        int[] coins = new int[]{
                1, 2, 5
        };
        int amount = 15;
        System.out.println(coinChange(coins,amount));
    }
    public static int coinChange(int[] coins, int amount) {
        int max = amount+1;
        int[] dp = new int[amount+1];
        Arrays.fill(dp,max);
        dp[0] = 0;
        for(int i=1;i<=amount;i++) {
            for(int j=0;j<coins.length;j++) {
                if(coins[j] <= i) {
                    dp[i] = Math.min(dp[i],dp[i-coins[j]]+1);
                }
            }
        }
        return dp[amount] > amount?-1:dp[amount];
    }
}
