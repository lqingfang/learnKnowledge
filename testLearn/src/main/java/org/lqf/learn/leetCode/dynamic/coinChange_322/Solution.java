package org.lqf.learn.leetCode.dynamic.coinChange_322;

/**
 * 递归，超时
 */
public class Solution {
    public static void main(String[] args) {

    }
    public int coinChange(int[] coins, int amount) {
        return coins(0,coins,amount);
    }

    private int coins(int idx, int[] coins, int amount) {
        if(amount == 0) {
            return 0;
        }
        if(coins.length > idx && amount>0) {
            int coinMax = amount/coins[idx];
            int minCost = Integer.MAX_VALUE;
            for(int k= 0;k<=coinMax;k++) {
                if(amount >=k*coins[idx]) {
                    int res = coins(idx+1,coins,amount-k*coins[idx]);
                    if(res != -1) {
                        minCost = Math.min(minCost,res+k);
                    }
                }
            }
            return minCost == Integer.MAX_VALUE?-1:minCost;
        }
        return -1;
    }
}
