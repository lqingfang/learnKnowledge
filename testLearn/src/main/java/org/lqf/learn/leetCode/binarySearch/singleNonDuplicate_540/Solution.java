package org.lqf.learn.leetCode.binarySearch.singleNonDuplicate_540;

/**
 * 二分
 */
public class Solution {
    public int singleNonDuplicate(int[] nums) {
        int len = nums.length;
        int left = 0;
        int right = len-1;
        while (left<right) {
            int mid = (left+right)/2;
            boolean one = (right-mid)%2 == 0;
            if(nums[mid] == nums[mid+1]) {
                if(one) {
                    //1 1 2 2 3
                    left = mid+2;
                }else {
                    //0 1 2 2 3 3
                    right = mid-1;
                }
            }else if(nums[mid] == nums[mid-1]) {
                if(one) {
                    //1 2 2 3 3
                    right = mid-2;
                }else {
                    //1 1 2 2 3 3 4
                    left = mid+1;
                }
            }else {
                return nums[mid];
            }
        }
        return nums[left];
    }
}
