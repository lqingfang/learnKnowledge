package org.lqf.learn.leetCode.binarySearch.firstBadVersion_278;

public class Solution02 {
    public int firstBadVersion(int n) {
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
    private boolean isBadVersion(int mid) {
        return true;
    }
}
