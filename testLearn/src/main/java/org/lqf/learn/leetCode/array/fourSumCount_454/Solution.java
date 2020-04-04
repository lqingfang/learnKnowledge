package org.lqf.learn.leetCode.array.fourSumCount_454;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int res = 0;
        int len = A.length;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<len;i++) {
            for(int j=0;j<len;j++) {
                int sum = A[i]+B[j];
                if(map.containsKey(sum)) {
                    map.put(sum,map.get(sum)+1);
                }else {
                    map.put(sum,1);
                }
            }
        }
        for(int i=0;i<len;i++) {
            for(int j=0;j<len;j++) {
                int sumCD = -(C[i]+D[j]);
                if(map.containsKey(sumCD)) {
                    res += map.get(sumCD);
                }
            }
        }
        return res;
    }
}
