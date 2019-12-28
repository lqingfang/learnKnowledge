package org.lqf.learn.leetCode.dynamic.findMaxForm_474;

public class Solution {
    public static void main(String[] args) {
        String[] strs = {"10", "0001", "111001", "1", "0"};
        int m = 5;
        int n = 3;
        System.out.println(findMaxForm(strs,m,n));
    }
    public static int findMaxForm(String[] strs, int m, int n) {
        if(strs.length == 0) {
            return 0;
        }
        int[][] dp = new int[m+1][n+1];
        for(String str:strs) {
            int ones = 0;
            int zeros = 0;
            for(char c:str.toCharArray()) {
                if(c =='0') {
                    zeros++;
                }else {
                    ones++;
                }
            }
            for(int j=m;j>=zeros;j--) {
                for(int k=n;k>=ones;k--) {
                    dp[j][k] = Math.max(dp[j][k],1+dp[j-zeros][k-ones]);
                }
            }
        }
        return dp[m][n];
    }
}
