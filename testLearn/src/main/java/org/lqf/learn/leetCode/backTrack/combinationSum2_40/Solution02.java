package org.lqf.learn.leetCode.backTrack.combinationSum2_40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution02 {
    public static void main(String[] args) {
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        System.out.println(combinationSum(candidates,target));
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates,0,new ArrayList<>(),target,res);
        return res;
    }
    private static void dfs(int[] candidates, int index,ArrayList<Integer> list, int target, List<List<Integer>> res) {
        if(0 == target) {
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i=index;i<candidates.length;i++) {
            if(candidates[i] > target) {
                continue;
            }
            if(i>index && candidates[i-1] == candidates[i]) {
                continue;
            }
            list.add(candidates[i]);
            dfs(candidates,i+1,list,target-candidates[i],res);
            list.remove(list.size()-1);
            }
    }
}
