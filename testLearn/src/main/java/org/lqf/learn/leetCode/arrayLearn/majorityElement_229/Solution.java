package org.lqf.learn.leetCode.arrayLearn.majorityElement_229;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {1,1,1,3,3,2,2,2};
        System.out.println(majorityElement(nums));
    }
    public static List<Integer> majorityElement(int[] nums) {
        if(null == nums || nums.length == 0) {
            return Collections.EMPTY_LIST;
        }
        List<Integer> res = new ArrayList<>();
        if(nums.length == 1) {
            res.add(nums[0]);
            return res;
        }

        int count_0 = 0;
        int count_1 = 0;
        int cur_0 = 0;
        int cur_1 = 0;

        for(int i=0;i<nums.length;i++) {
            if(nums[i] == cur_0) {
                count_0++;
                continue;
            }
            if(nums[i] == cur_1) {
                count_1++;
                continue;
            }
            if(nums[i] != cur_0 && count_0 == 0) {
                cur_0 = nums[i];
                count_0 = 1;
                continue;
            }
            if(nums[i] != cur_1 && count_1 == 0) {
                cur_1 = nums[i];
                count_1 = 1;
                continue;
            }
            count_0--;
            count_1--;
        }
        count_0 = count_1 = 0;
        for(int i=0;i<nums.length;i++) {
            if(nums[i] == cur_0) {
                count_0++;
            }else if(nums[i] == cur_1) {
                count_1++;
            }
        }
        if (count_0 >0 && nums.length/count_0 <3) {
            res.add(cur_0);
        }
        if (count_1 >0 && nums.length/count_1 < 3) {
            res.add(cur_1);
        }
        return res;
    }

}
