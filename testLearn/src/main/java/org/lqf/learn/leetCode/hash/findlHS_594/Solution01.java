package org.lqf.learn.leetCode.hash.findlHS_594;

import java.util.HashMap;
import java.util.Map;

public class Solution01 {
    public int findLHS(int[] nums) {
        Map<Integer,Integer> countMap = new HashMap<>();
        for(int num:nums) {
            countMap.put(num,countMap.getOrDefault(num,0)+1);
        }
        int res = 0;
        for(int key :countMap.keySet()) {
            if(countMap.containsKey(key+1)) {
                res = Math.max(res,countMap.get(key)+countMap.get(key+1));
            }
        }
        return res;
    }
}
