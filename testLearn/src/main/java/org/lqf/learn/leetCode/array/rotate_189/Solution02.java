package org.lqf.learn.leetCode.array.rotate_189;

public class Solution02 {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k = k%len;
        reverse(nums,len-k,len-1);
        reverse(nums,0,len-k-1);
        reverse(nums,0,len-1);
    }

    private void reverse(int[] nums, int left, int right) {
        while (left<right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}
