package org.lqf.learn.leetCode.binarySearch.mySqrt_69;

/**
 * 二分
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(mySqrt(2));
    }
    public static int mySqrt(int x) {
        if(x<2) {
            return x;
        }
        int left = 2;
        int right = x/2;
        long num;
        while (left<=right) {
            int mid = left+(right-left)/2;
            num = (long)mid * mid;
            if(num > x) {
                right = mid-1;
            }else if(num <x) {
                left = mid+1;
            }else {
                return mid;
            }
        }
        return right;
    }
}
