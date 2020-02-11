package org.lqf.learn.leetCode.bfsAndDfs.numSquares_279;

public class Solution02 {
    public static void main(String[] args) {
        System.out.println(numSquares(8));
    }
    public static int numSquares(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        for(int i=2;i<=n;i++) {
            dp[i] = i;
            for(int j=1;i-j*j>=0;j++) {
                dp[i] = Math.min(dp[i],dp[i-j*j]+1);
            }
        }
        return dp[n];
    }
}
