package org.lqf.learn.leetCode.backTrack.combine_77;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        int n=4,k=2;
        System.out.println(combine(n,k));
    }
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(n,k,1,new ArrayList<Integer>(),new boolean[n+1],res);
        return res;
    }

    private static void dfs(int n, int k, int index,List<Integer> list,boolean[] visited,List<List<Integer>> res) {
        if(list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i=index;i<=n;i++) {
            if(visited[i]) {
                continue;
            }
            visited[i] = true;
            list.add(i);
            dfs(n,k,i+1,list,visited,res);
            visited[i] = false;
            list.remove(list.size()-1);
        }
    }

}
