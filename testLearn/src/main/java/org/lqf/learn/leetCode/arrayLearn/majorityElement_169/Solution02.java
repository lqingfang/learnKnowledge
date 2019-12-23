package org.lqf.learn.leetCode.arrayLearn.majorityElement_169;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution02 {
    public static void main(String[] args) {
        int[] nums = {3,2,3};
        System.out.println(majorityElement(nums));
    }
    public static List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int size = nums.length;
        Map map = new HashMap<Integer,Integer>();
        for(int c:nums) {
            map.put(c,(Integer)map.getOrDefault(c,0)+1);
            if((Integer)map.get(c) > size/3 && !res.contains(c)) {
                res.add(c);
            }
        }
        return res;
    }
}
