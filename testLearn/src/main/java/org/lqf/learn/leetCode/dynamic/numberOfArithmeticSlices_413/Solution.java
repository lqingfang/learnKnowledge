package org.lqf.learn.leetCode.dynamic.numberOfArithmeticSlices_413;

public class Solution {
    public static void main(String[] args) {
        int[] A = {2,4,6,8,10};
        System.out.println(numberOfArithmeticSlices(A));
    }
    public static int numberOfArithmeticSlices(int[] A) {
        if(A.length < 2) {
            return 0;
        }
        int[] dp = new int[A.length];
        for(int i=2;i<A.length;i++) {
            if(A[i]-A[i-1] == A[i-1] - A[i-2]) {
                dp[i] = dp[i-1]+1;
            }
        }
        int sum = 0;
        for(int num :dp) {
            sum += num;
        }
        return sum;
    }
}
