package org.lqf.learn.leetCode.fib;

public class Solution {
    public static void main(String[] args) {
        System.out.println(fib(40)+"---"+count);
    }

    static int count = 0;
    private static int fib(int n) {
        count++;
        if(n==0){
            return 0;
        }
        if(n==1) {
            return 1;
        }
        return fib(n-2)+fib(n-1);
    }
}
