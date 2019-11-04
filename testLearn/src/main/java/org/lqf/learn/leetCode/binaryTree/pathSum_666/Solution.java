package org.lqf.learn.leetCode.binaryTree.pathSum_666;


import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {113, 215, 221};
        System.out.println(pathSum(nums));
    }

    static int current;
    static int res;

    private static int pathSum(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int x:nums) {
            int dep = x/100;
            int pos = x/10%10;
            int val = x%10;
            int position = (int)Math.pow(2,dep-1) + pos-1;
            map.put(position,val);
        }
        getSum(map,1);
        return res;
    }

    private static void getSum(Map<Integer, Integer> map, int index) {
        if(!map.containsKey(index)) {
            return;
        }
        current += map.get(index);
        if(!map.containsKey(2*index) && !map.containsKey(2*index+1)) {
            res = res + current;
        }
        if(map.containsKey(2*index)) {
            getSum(map,2*index);
        }
        if(map.containsKey(2*index+1)) {
            getSum(map,2*index+1);
        }
        current = current - map.get(index);
    }

}
