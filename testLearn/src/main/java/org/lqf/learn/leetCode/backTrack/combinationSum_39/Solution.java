package org.lqf.learn.leetCode.backTrack.combinationSum_39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        int target = 7;
        System.out.println(combinationSum(candidates,target));
    }
    static List<List<Integer>> res = new ArrayList<>();
    static int len;
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        len = candidates.length;
        findCombinationSum(candidates,0,target,new Stack<Integer>());
        return res;
    }

    private static void findCombinationSum(int[] candidates,int start, int residue,Stack stack) {
        if(residue == 0) {
            res.add(new ArrayList<>(stack));
            return;
        }
        for(int i= start;i<len && residue-candidates[i] >=0;i++) {
            stack.add(candidates[i]);
            findCombinationSum(candidates,i,residue-candidates[i],stack);
            stack.pop();
        }
    }
}
