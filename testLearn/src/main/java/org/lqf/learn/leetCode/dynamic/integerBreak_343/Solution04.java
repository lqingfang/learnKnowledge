package org.lqf.learn.leetCode.dynamic.integerBreak_343;

/**
 * dp[i]=3*dp[i-3]
 */
public class Solution04 {
    public static void main(String[] args) {
        System.out.println(integerBreak(10));
    }
    public static int integerBreak(int n) {
        if(n<=3) {
            return n-1;
        }
        int a = n/3;
        int b = n%3;
        if(b==0) {
            return (int)Math.pow(3,a);
        }else if(b==1) {
            return (int)Math.pow(3,a-1)*4;
        }else {
            return (int)Math.pow(3,a)*2;
        }
    }
}
