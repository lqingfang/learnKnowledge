package org.lqf.learn.leetCode.dynamic.integerBreak_343;

public class Solution02 {
    public static void main(String[] args) {
        System.out.println(integerBreak(10));
    }
    public static int integerBreak(int n) {
        if(n<=2) {
            return 1;
        }
        if(n == 3) {
            return 2;
        }
        if(n == 4) {
            return 4;
        }
        if(n == 5) {
            return 6;
        }
        if(n == 6) {
            return 9;
        }
        return 3*integerBreak(n-3);
    }
}
