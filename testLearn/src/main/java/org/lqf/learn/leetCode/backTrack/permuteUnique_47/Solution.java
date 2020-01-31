package org.lqf.learn.leetCode.backTrack.permuteUnique_47;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1、排序
 * 2、相同的两个元素，前一个如果使用了，后一个再使用，否则会重复
 */
public class Solution {
    public static void main(String[] args) {

    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        dfs(nums,0,visited,new ArrayList<>(),res);
        return res;
    }

    private void dfs(int[] nums, int index, boolean[] visited, List list,List<List<Integer>> res) {
        if(index == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i=0;i<nums.length;i++) {
            if(visited[i]) {
                continue;
            }
            if(i>0 && nums[i] == nums[i-1] && !visited[i-1]) {
                continue;
            }
            visited[i] = true;
            list.add(nums[i]);
            dfs(nums,index+1,visited,list,res);
            visited[i] = false;
            list.remove(list.size()-1);
        }
    }
}
