package org.lqf.learn.leetCode.dynamicPro.climbStairs_70;

public class Solution02 {
    public static void main(String[] args) {
        System.out.println(climbStairs(3));
    }
    public static int climbStairs(int n) {
        if(n<=2){
            return n;
        }
        int first_step = 1;
        int second_step = 2;
        int n_step = 0;
        for (int i=3;i<n+1;i++) {
            n_step = first_step+second_step;
            first_step = second_step;
            second_step = n_step;
        }
        return n_step;
    }
}
