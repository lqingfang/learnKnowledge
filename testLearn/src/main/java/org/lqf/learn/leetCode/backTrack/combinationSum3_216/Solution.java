package org.lqf.learn.leetCode.backTrack.combinationSum3_216;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        int k= 3;
        int n = 9;
        System.out.println(combinationSum3(k,n));
    }
    static List<List<Integer>> res = new ArrayList<>();
    public static List<List<Integer>> combinationSum3(int k, int n) {
        getCombinationSum(1,k,n,new Stack<Integer>());
        return res;
    }

    private static void getCombinationSum(int start,int curReiusSize, int target, Stack<Integer> stack) {
        if(curReiusSize <0) {
            return;
        }
        if(curReiusSize == 0 && target==0) {
            res.add(new ArrayList<>(stack));
            return;
        }
        for(int i=start;i<10 && i<=target;i++) {
            if(!stack.isEmpty() && i>start && i<=stack.peek()) {
                continue;
            }
            if(!stack.isEmpty() && stack.contains(i)) {
                continue;
            }
            stack.add(i);
            getCombinationSum(i+1,curReiusSize-1,target-i,stack);
            stack.pop();
        }
    }
}
