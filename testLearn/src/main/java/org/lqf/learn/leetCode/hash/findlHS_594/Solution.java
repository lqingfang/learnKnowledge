package org.lqf.learn.leetCode.hash.findlHS_594;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        int[] nums = {1,3,2,2,5,2,3,};
        System.out.println(findLHS(nums));
    }
    private static int findLHS(int[] nums) {
        Map<Integer,Integer> countMap = new HashMap<>();
        for(int i:nums) {
            countMap.put(i,countMap.getOrDefault(i,0)+1);
        }
        int res = 0;
        for(int key:countMap.keySet()) {
            if(countMap.containsKey(key+1)) {
                res = Math.max(res,countMap.get(key)+countMap.get(key+1));
            }
        }
        return res;
    }
}
