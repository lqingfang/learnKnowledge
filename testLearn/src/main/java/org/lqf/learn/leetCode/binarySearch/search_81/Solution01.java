package org.lqf.learn.leetCode.binarySearch.search_81;

public class Solution01 {
    public static void main(String[] args) {
        int[] nums = {1,1};
        int target = 0;
        System.out.println(search(nums,target));
    }

    public static boolean search(int[] nums, int target) {
        int len = nums.length;
        if(len== 0) {
            return false;
        }
        if(len == 1) {
            return nums[0]== target;
        }
        //说明顺序是正确的
        if(nums[0] < nums[len-1]) {
            return findTarget(0,len-1,nums,target);
        }
        int left = 0;
        int right = len-1;
        //找到最小位置
        int min = 0;
        while (left<right) {
            int mid = (left+right)>>1;
            if(nums[mid] > nums[mid+1]) {
                min = mid+1;
                break;
            }
            if(mid-1>=0 && nums[mid-1] > nums[mid]) {
                min = mid;
                break;
            }
            // 5 6 7 8 9 0 1 2
            // 5 6 0 1 2 3 4
            if(nums[mid] > nums[right]) {
                left = mid+1;
            } else if(nums[mid] < nums[right]){
                right = mid-1;
            } else {
                if(nums[right] < nums[right-1]) {
                    min = right;
                    break;
                }
                right--;
            }
        }
        if(nums[0] <= target && min-1>=0 && target <= nums[min-1]) {
            return findTarget(0,min-1,nums,target);
        }else if(nums[min] <= target && target <= nums[len-1]){
            return findTarget(min,len-1,nums,target);
        }
        return false;
    }

    public static boolean findTarget(int left, int right, int[] nums, int target) {
        while (left < right) {
            int mid = (left+right)>>1;
            if(nums[mid] == target) {
                return true;
            }else if(nums[mid] > target) {
                right = mid-1;
            }else {
                left = mid+1;
            }
        }
        return nums[left] == target;
    }
}
