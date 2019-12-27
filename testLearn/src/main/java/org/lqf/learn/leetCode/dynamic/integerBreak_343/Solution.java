package org.lqf.learn.leetCode.dynamic.integerBreak_343;

public class Solution {
    public static void main(String[] args) {

    }
    public int integerBreak(int n) {
        if(n<=2) {
            return 1;
        }
        if(n == 3) {
            return 2;
        }
        if(n == 4) {
            return 4;
        }
        int res = 1;
        while (n>4) {
            res *=3;
            n = n-3;
        }
        res *=n;
        return res;
    }
}
