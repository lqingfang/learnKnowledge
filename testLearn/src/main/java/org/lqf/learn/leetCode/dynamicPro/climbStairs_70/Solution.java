package org.lqf.learn.leetCode.dynamicPro.climbStairs_70;

public class Solution {
    public static void main(String[] args) {
        System.out.println(climbStairs(3));
    }
    public static int climbStairs(int n) {
        if(n==0 || n==1 || n==2) {
            return n;
        }
        int[] mount = new int[n+1];
        mount[1] = 1;
        mount[2] = 2;
        for(int i=3;i<n+1;i++) {
            mount[i] = mount[i-1] + mount[i-2];
        }
        return mount[n];
    }
}
