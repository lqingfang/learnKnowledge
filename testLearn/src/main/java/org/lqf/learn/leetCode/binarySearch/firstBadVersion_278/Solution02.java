package org.lqf.learn.leetCode.binarySearch.firstBadVersion_278;

public class Solution02 {
    public static void main(String[] args) {
        System.out.println(firstBadVersion(5));
    }
    public static int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while (left < right) {
            int mid = left + (right-left)/2;
            if(isBadVersion(mid)) {
                right = mid;
                if(mid == 1) {
                    return 1;
                }
                if(!isBadVersion(mid-1)) {
                    return mid;
                }
            }else {
                left = mid+1;
            }
        }
        return left;
    }
    private static boolean isBadVersion(int mid) {
        if(mid >=4) {
            return true;
        }
        return false;
    }
}
