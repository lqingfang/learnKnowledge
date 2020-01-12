package org.lqf.learn.leetCode.dynamic.coinChange_322;

public class Solution002 {
    public static void main(String[] args) {
        int[] coins = new int[]{
            1,2,5
        };
        int amount = 11;
        System.out.println(coinChange(coins,amount));
    }

    public static int coinChange(int[] coins, int amount) {
        if(amount<1) {
            return 0;
        }
        return getCoinCount(coins,amount,new int[amount]);
    }
    private static int getCoinCount(int[] coins, int amount, int[] count) {
        if(amount < 0) {
            return -1;
        }
        if(amount==0) {
            return 0;
        }
        if(count[amount-1] !=0) {
            return count[amount-1];
        }
        int min = Integer.MAX_VALUE;
        for(int coin:coins) {
            int res = getCoinCount(coins,amount-coin,count);
            if(res >=0 && res <min) {
                min = 1+res;
            }
        }
        count[amount-1] = (min==Integer.MAX_VALUE)?-1:min;
        return count[amount-1];
    }

}
