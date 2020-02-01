package org.lqf.learn.leetCode.backTrack.combinationSum_39;

import java.util.*;

public class Solution03 {
    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        int target = 7;
        System.out.println(combinationSum(candidates,target));
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer,Set<List<Integer>>> dp = new HashMap<>();
        for(int i=1;i<=target;i++) {
            dp.put(i,new HashSet<>());
            for(int j=0;j<candidates.length;j++) {
                if(candidates[j] == i) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(candidates[j]);
                    dp.get(i).add(temp);
                }else if(i > candidates[j]) {
                    int key = i-candidates[j];
                    Iterator<List<Integer>> iterator = dp.get(key).iterator();
                    while (iterator.hasNext()) {
                        List<Integer> temp = new ArrayList<>();
                        temp.addAll(iterator.next());
                        temp.add(candidates[j]);
                        Collections.sort(temp);
                        dp.get(i).add(temp);
                    }
                }
            }
        }
        res.addAll(dp.get(target));
        return res;
    }
}
