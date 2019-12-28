package org.lqf.learn.leetCode.dynamic.coinChange_322;

/**
 * 动态规划-自上而下
 */
public class Solution02 {
    public static void main(String[] args) {

    }
    public int coinChange(int[] coins, int amount) {
        return coins(coins,amount,new int[amount]);
    }

    private int coins(int[] coins, int amount,int[] res) {
        if(amount == 0) {
            return 0;
        }
        if(amount < 0) {
            return -1;
        }
        if(res[amount-1]!= 0) {
            return res[amount-1];
        }
        int min = Integer.MAX_VALUE;
        for(int coin : coins) {
            int coinCost = coins(coins,amount-coin,res);
            if(coinCost >= 0 && coinCost < min) {
                min = coinCost+1;
            }
        }
        res[amount-1] = min==Integer.MAX_VALUE?-1:min;
        return res[amount-1];
    }
}
