package org.lqf.learn.leetCode.backTrack.combinationSum2_40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        System.out.println(combinationSum2(candidates,target));
    }
    static List<List<Integer>> res = new ArrayList<>();
    static int len;
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        len = candidates.length;
        findCombinationSum(candidates,target,0,new Stack<Integer>());
        return res;
    }

    private static void findCombinationSum(int[] candidates, int redius, int start,Stack stack) {
        if(redius == 0) {
            res.add(new ArrayList<>(stack));
            return;
        }
        for(int i=start;i<len && redius-candidates[i]>=0;i++) {
            // 相同部分剪枝
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            stack.add(candidates[i]);
            findCombinationSum(candidates,redius-candidates[i],i+1,stack);
            stack.pop();
        }
    }
}
