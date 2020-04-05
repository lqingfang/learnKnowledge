package org.lqf.learn.leetCode.array.findDisappearedNumbers_448;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        System.out.println(findDisappearedNumbers(nums));
    }
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        Arrays.sort(nums);
        //1 2 2 3 3 4 7 8
        int pre = 0;
        int len = nums.length;
        for(int i=0;i<len;i++) {
            if(nums[i] == pre+1 || nums[i] == pre) {
                pre = nums[i];
                continue;
            }
            while (pre+1 < nums[i]) {
                res.add(pre+1);
                pre = pre+1;
            }
            pre = nums[i];
        }
        while (pre<len) {
            pre = pre+1;
            res.add(pre);
        }
        return res;
    }
}
