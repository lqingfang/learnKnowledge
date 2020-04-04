package org.lqf.learn.leetCode.array.fourSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution02 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        Arrays.sort(nums);
        for(int i=0;i<len-3;i++) {
            if(i==0 || nums[i-1] != nums[i]) {
                for(int j=i+1;j<len-2;j++) {
                    if(j==i+1 || nums[j] != nums[j-1]){
                        int start = j+1;
                        int end = len-1;
                        while (start<end) {
                            int tempSum = nums[i]+nums[j]+nums[start]+nums[end];
                            if(tempSum == target) {
                                res.add(Arrays.asList(nums[i],nums[j],nums[start],nums[end]));
                                while (start<end && nums[start] == nums[start+1]) {
                                    start++;
                                }
                                while (start<end && nums[end] == nums[end-1]) {
                                    end--;
                                }
                                start++;
                                end--;
                            }else if(tempSum <target) {
                                start++;
                            }else {
                                end--;
                            }
                        }
                    }
                }
            }
        }
        return res;
    }
}
