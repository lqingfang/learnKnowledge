package org.lqf.learn.leetCode.dynamic.change_518;

public class Solution {
    public static void main(String[] args) {

    }
    public int change(int amount, int[] coins) {
        int len = coins.length;
        int[][] dp = new int[len+1][amount+1];
        dp[0][0] = 1;
        for(int i = 1;i<=len;i++) {
            for(int j=0;j<=amount;j++) {
                dp[i][j] = dp[i-1][j];
                if(j-coins[i-1] >=0) {
                    dp[i][j] +=dp[i][j-coins[i-1]];
                }
            }
        }
        return dp[len][amount];
    }
}
