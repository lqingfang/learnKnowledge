package org.lqf.learn.leetCode.backTrack.permute_46;

import java.util.ArrayList;
import java.util.List;

/**
 * 这个数可以放哪个位置
 */
public class Solution02 {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(permute(nums));
    }
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        getList(nums,0,new ArrayList<>(),new boolean[nums.length],res);
        return res;
    }

    private static void getList(int[] nums, int index, List<Integer> list,boolean[] visited,List<List<Integer>> res) {
        if(index == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i=0;i<nums.length;i++) {
            if(!visited[i]) {
                list.add(nums[i]);
                visited[i] = true;
                getList(nums,index+1,list,visited,res);
                visited[i] = false;
                list.remove(list.size()-1);
            }
        }
    }
}
