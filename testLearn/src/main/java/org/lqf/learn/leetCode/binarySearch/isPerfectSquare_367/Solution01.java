package org.lqf.learn.leetCode.binarySearch.isPerfectSquare_367;

public class Solution01 {
    public boolean isPerfectSquare(int num) {
        if(num<2) {
            return true;
        }
        int left = 2;
        int right = num/2;
        long squart;
        while (left<=right) {
            int mid = left+(right-left)/2;
            squart = (long)mid * mid;
            if(squart > num) {
                right = mid-1;
            }else if(squart <num) {
                left = mid+1;
            }else {
                return true;
            }
        }
        return false;
    }
}
