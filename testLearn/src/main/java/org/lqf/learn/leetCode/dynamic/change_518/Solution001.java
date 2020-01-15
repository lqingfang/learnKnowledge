package org.lqf.learn.leetCode.dynamic.change_518;

public class Solution001 {
    public static void main(String[] args) {

    }
    static int count = 0;
    public int coinChange(int[] coins, int amount) {
        getCoinCount(coins,amount,0);
        return count;
    }
    private int getCoinCount(int[] coins, int amount, int index) {
        if(amount==0) {
            count++;
            return 0;
        }

        if(index < coins.length && amount>0) {
            int num = amount/coins[index];
            int minCost = Integer.MAX_VALUE;
            for(int i=0;i<=num;i++) {
                if(amount>=num*coins[index]) {
                    int res = getCoinCount(coins, amount - i * coins[index], index + 1);
                    if(res !=-1) {
                        minCost = Math.min(minCost,i+res);
                    }
                }
            }
            return minCost==Integer.MAX_VALUE?-1:minCost;
        }
        return -1;
    }
}
