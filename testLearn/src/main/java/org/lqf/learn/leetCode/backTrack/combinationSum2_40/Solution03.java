package org.lqf.learn.leetCode.backTrack.combinationSum2_40;

import java.util.*;

/**
 * 动态规划有重复的，暂时还不行
 */
public class Solution03 {
    public static void main(String[] args) {
        int[] candidates = {1,1,2,5,6,7,10};
        int target = 8;
        System.out.println(combinationSum(candidates,target));
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer,Set<List<Integer>>> dp = new HashMap<>();
        for(int i=1;i<=target;i++) {
            boolean[] visited = new boolean[i+1];
            dp.put(i,new HashSet<>());
            for(int j=0;candidates[j]<=i && j<candidates.length;j++) {
                if(candidates[j] == i) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(candidates[j]);
                    dp.get(i).add(temp);
                }else if(i>candidates[j]) {
                    int key = i-candidates[j];
                    if(!visited[key]) {
                        visited[key] = true;
                        Iterator<List<Integer>> iterator = dp.get(key).iterator();
                        while (iterator.hasNext()) {
                            List<Integer> temp = new ArrayList<>();
                            temp.addAll(iterator.next());
                            temp.add(candidates[j]);
                            Collections.sort(temp);
                            dp.get(i).add(temp);
                        }
                    }else {
                        continue;
                    }
                }
            }
        }
        res.addAll(dp.get(target));
        return res;
    }
}
