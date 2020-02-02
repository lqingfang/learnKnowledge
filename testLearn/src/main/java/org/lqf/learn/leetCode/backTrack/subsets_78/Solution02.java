package org.lqf.learn.leetCode.backTrack.subsets_78;

import java.util.ArrayList;
import java.util.List;

public class Solution02 {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(subsets(nums));
    }
    public static List<List<Integer>> subsets(int[] nums) {
       List<List<Integer>> res = new ArrayList<>();
       dfs(nums,0,new ArrayList<>(),res);
       return res;
    }

    private static void dfs(int[] nums, int index, ArrayList<Integer> list, List<List<Integer>> res) {
        res.add(new ArrayList<>(list));
        for(int i=index;i<nums.length;i++) {
            list.add(nums[i]);
            dfs(nums,i+1,list,res);
            list.remove(list.size()-1);
        }
    }


}
