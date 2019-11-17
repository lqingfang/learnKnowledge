package org.lqf.learn.leetCode.dynamicPro.lengthOfLIS_300;

public class Solution02 {
    public static void main(String[] args) {
        int[] nums = new int[]{10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(nums));
    }
    public static int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length ==0) {
            return 0;
        }
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int len = 1;
        for(int i=1;i<nums.length;i++) {
            int index = search(dp,nums[i],len-1);
            dp[index] = nums[i];
            if(index == len) {
                len++;
            }
        }
        return len;
    }
    public static int search(int[] nums,int key,int r) {
        int l = 0;
        int mid;
        while (l<=r) {
            mid = l+((r-l)>>1);
            if(nums[mid] >key) {
                r = mid-1;
            }else if(nums[mid] < key) {
                l = mid+1;
            }else {
                return mid;
            }
        }
        return l;
    }
}
