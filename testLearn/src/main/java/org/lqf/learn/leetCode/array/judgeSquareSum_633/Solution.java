package org.lqf.learn.leetCode.array.judgeSquareSum_633;

public class Solution {
    public static void main(String[] args) {
        System.out.println(judgeSquareSum(4));
    }
    public static boolean judgeSquareSum(int c) {
        int left = 0;
        int right = (int)Math.sqrt(c);
        while (left<=right) {
            int num = left*left + right *right;
            if( num == c) {
                return true;
            }
            if(num<c) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }
}
