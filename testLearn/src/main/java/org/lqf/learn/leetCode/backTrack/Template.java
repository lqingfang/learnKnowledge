package org.lqf.learn.leetCode.backTrack;

import java.util.ArrayList;
import java.util.List;

public class Template {
    public static void main(String[] args) {

    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, 0,new ArrayList<>(), res);
        return res;
    }
    public static void backtrack(int[] nums,int index,List<Integer> list,List<List<Integer>> res) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            // 做选择
            list.add(nums[i]);
            // 进入下一层决策树
            backtrack(nums, i+1,list,res);
            // 取消选择，返回上一层决策树
            list.remove(list.size()-1);
        }
    }
}
