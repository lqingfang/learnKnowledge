package org.lqf.learn.leetCode.binarySearch.isPerfectSquare_367;

public class Solution {
    public static void main(String[] args) {
        int num = 34;
        System.out.println(isPerfectSquare(num));
    }

    private static boolean isPerfectSquare(int num) {
        long a = num;
        while (a*a >num) {
            a = (num/a +a)/2;
        }
        return a*a==num;
    }
}
