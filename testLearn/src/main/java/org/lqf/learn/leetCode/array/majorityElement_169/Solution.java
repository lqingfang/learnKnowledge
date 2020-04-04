package org.lqf.learn.leetCode.array.majorityElement_169;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {3,2,3};
        System.out.println(majorityElement(nums));
    }
    public static int majorityElement(int[] nums) {
        int size = nums.length;
        Map map = new HashMap<Integer,Integer>();
        for(int c:nums) {
            map.put(c,(Integer)map.getOrDefault(c,0)+1);
            if((Integer)map.get(c) > size/2) {
                return c;
            }
        }
        return 0;
    }
}
