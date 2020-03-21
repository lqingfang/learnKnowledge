package org.lqf.learn.leetCode.binarySearch.findDuplicate_287;

public class Solution02 {
    public static void main(String[] args) {
        int[] nums = {2,5,9,6,9,3,8,9,7,1};
        System.out.println(findDuplicate(nums));
    }
    public static int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while (fast!=slow);

        fast = nums[0];
        while (fast != slow) {
            fast = nums[fast];
            slow = nums[slow];
        }
        return fast;
    }
}
