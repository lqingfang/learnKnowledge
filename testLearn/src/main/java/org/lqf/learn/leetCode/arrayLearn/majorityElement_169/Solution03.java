package org.lqf.learn.leetCode.arrayLearn.majorityElement_169;


public class Solution03 {
    public static void main(String[] args) {
        int[] nums = {6,6,7,7,7,6,6};
        System.out.println(majorityElement(nums));
    }
    public static int majorityElement(int[] nums) {
        int count = 1;
        int cur = nums[0];
        for(int i=1;i<nums.length;i++) {
            if(nums[i] == cur) {
                count++;
            }else if(count==0) {
                cur = nums[i];
                count=1;
            }else {
                count--;
            }
        }
        return cur;
    }
}
