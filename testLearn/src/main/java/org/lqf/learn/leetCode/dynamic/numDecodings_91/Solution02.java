package org.lqf.learn.leetCode.dynamic.numDecodings_91;

public class Solution02 {
    public static void main(String[] args) {
        System.out.println(numDecodings("101"));
    }
    public static int numDecodings(String s) {
        int len = s.length();
        int[] dp = new int[len+1];
        dp[len] = 1;
        if(s.charAt(len-1) != '0') {
            dp[len-1] = 1;
        }
        for(int i = len-2;i>=0;i--) {
            if(s.charAt(i) == '0') {
                continue;
            }
            int ans1 = dp[i+1];
            int ans2 = 0;
            int ten = (s.charAt(i)-'0') * 10;
            int one = s.charAt(i+1)-'0';
            if(ten+one <= 26) {
                ans2 = dp[i+2];
            }
            dp[i] = ans1 + ans2;
        }
        return dp[0];
    }
}
