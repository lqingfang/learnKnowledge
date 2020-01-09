package org.lqf.learn.leetCode.dynamic.integerBreak_343;

/**
 * dp[i]=3*dp[i-3]
 */
public class Solution03 {
    public static void main(String[] args) {
        System.out.println(integerBreak(10));
    }
    public static int integerBreak(int n) {
        int[] dp = new int[n+1];
        dp[1]=1;
        if(n==1) {
            return dp[n];
        }
        dp[2]=1;
        if(n==2) {
            return dp[n];
        }
        dp[3]=2;
        if(n==3) {
            return dp[n];
        }
        dp[4]=4;
        if(n==4) {
            return dp[n];
        }
        dp[5]=6;
        if(n==5) {
            return dp[n];
        }
        dp[6]=9;
        if(n==6) {
            return dp[n];
        }
        for(int i=7;i<=n;i++) {
            dp[i] = 3*dp[i-3];
        }
        return dp[n];
    }
}
