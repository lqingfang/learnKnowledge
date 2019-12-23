package org.lqf.learn.leetCode.greedy.maxProfit_121;

public class Solution {
    public static void main(String[] args) {

    }
    public int maxProfit(int[] prices) {
        int profit = 0;
        for(int i=0;i<prices.length;i++) {
            for(int j=i+1;j<prices.length;j++) {
                if(prices[i] >= prices[j]) {
                    continue;
                }else {
                    if(profit < (prices[j]-prices[i])) {
                        profit = prices[j]-prices[i];
                    }
                }
            }
        }
        return profit;
    }
}
