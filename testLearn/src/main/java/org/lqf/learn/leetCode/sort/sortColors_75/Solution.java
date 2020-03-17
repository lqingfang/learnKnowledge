package org.lqf.learn.leetCode.sort.sortColors_75;

public class Solution {
    public void sortColors(int[] nums) {
        int len = nums.length;
        if(len < 2) {
            return;
        }
        int left = 0;
        int right = len -1;
        int cur = 0;
        while (cur <= right) {
            if(cur < left || nums[cur] == 1) {
                cur++;
            }else if(nums[cur] == 2) {
                swap(nums,cur,right--);
            }else if(nums[cur] == 0) {
                swap(nums,cur,left++);
            }
        }
    }
    public void swap(int[] nums,int one,int two) {
        int temp = nums[one];
        nums[one] = nums[two];
        nums[two] = temp;
    }
}
