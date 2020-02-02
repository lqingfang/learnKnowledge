package org.lqf.learn.leetCode.backTrack.subsetsWithDup_90;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution02 {
    public static void main(String[] args) {
        int[] nums = {1,2,2};
        System.out.println(subsets(nums));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums,0,new ArrayList<>(),res);
        return res;
    }
    private static void dfs(int[] nums, int index, ArrayList<Integer> list, List<List<Integer>> res) {
        res.add(new ArrayList<>(list));
        //是给同一个位置赋值，index 是nums开始的位置，也是给list的第几个数赋值
        //比如，给list的第二个数赋值，i大于index，使用nums第三个数赋值时，发现第三个数和第二个数一样，则跳过
        for(int i=index;i<nums.length;i++) {
            if(i>index && nums[i] == nums[i-1]) {
                continue;
            }
            list.add(nums[i]);
            dfs(nums,i+1,list,res);
            list.remove(list.size()-1);
        }
    }

}
