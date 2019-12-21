package org.lqf.learn.leetCode.backTrack.subsetsWithDup_90;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {1,2,2};
        System.out.println(subsets(nums));
    }
    static List<List<Integer>> res = new ArrayList<>();
    public static List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        dfs(nums,0,new Stack<Integer>());
        return res;
    }

    private static void dfs(int[] nums,int start,Stack stack) {
        if(!res.contains(new ArrayList<>(stack))) {
            res.add(new ArrayList<>(stack));
        }
        for(int i=start;i<nums.length;i++) {
            stack.add(nums[i]);
            dfs(nums,i+1,stack);
            stack.pop();
        }
    }
}
