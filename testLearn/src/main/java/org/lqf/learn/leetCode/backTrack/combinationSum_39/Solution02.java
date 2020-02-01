package org.lqf.learn.leetCode.backTrack.combinationSum_39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Solution02 {
    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        int target = 7;
        System.out.println(combinationSum(candidates,target));
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
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
            int num = target/candidates[i];
            for(int j=1;j<=num;j++) {
                int k = j;
                while (k>0) {
                    list.add(candidates[i]);
                    k--;
                }
                dfs(candidates,i+1,list,target-candidates[i]*j,res);
                while (k<j) {
                    list.remove(list.size()-1);
                    k++;
                }

            }
        }
    }
}
