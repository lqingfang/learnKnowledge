package org.lqf.learn.leetCode.array.twoSum_1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution001 {
    public static void main(String[] args) {
        int[] arry = {2,5,4,6,8,1};
        int[] result = twoSum(arry,9);
        System.out.println(Arrays.toString(result));
    }
    public static int[] twoSum(int[] nums, int target) {
        for(int i=0;i<nums.length-1;i++) {
            for(int j=i+1;j<nums.length;j++) {
                if(nums[i] + nums[j] == target) {
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{-1,-1};
    }
    public static int[] twoSum02(int[] nums, int target) {
        Map<Integer,Integer> sumMap = new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++) {
            int num = target-nums[i];
            if(sumMap.get(num) != null) {
                return new int[]{sumMap.get(num),i};
            }else {
                sumMap.put(nums[i],i);
            }

        }
        return new int[]{-1,-1};
    }

    /**
     * 排序好的
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum03(int[] nums, int target) {
        Arrays.sort(nums);
        int i=0,j=nums.length-1;
        while (i<j){
            if(nums[i]+nums[j] > target) {
                j--;
            }else if(nums[i]+nums[j] < target) {
                i++;
            }else {
                return new int[]{i,j};
            }
        }
        return new int[]{-1,-1};
    }
}
