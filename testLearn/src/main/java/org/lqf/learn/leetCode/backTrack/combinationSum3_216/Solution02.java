package org.lqf.learn.leetCode.backTrack.combinationSum3_216;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution02 {
    public static void main(String[] args) {
        int k= 3;
        int n = 9;
        System.out.println(combinationSum3(k,n));
    }
    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(k,1,0,n,new ArrayList<>(),res);
        return res;
    }

    private static void dfs(int k, int index,int sum,int n, List<Integer> list,List<List<Integer>> res) {
        if(sum > n || list.size() > k) {
            return;
        }
        if(sum == n && list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i = index;i<10;i++) {
            sum +=i;
            list.add(i);
            dfs(k,i+1,sum,n,list,res);
            sum -=i;
            list.remove(list.size()-1);
        }
    }
}
