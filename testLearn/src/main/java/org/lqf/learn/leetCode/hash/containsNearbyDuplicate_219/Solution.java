package org.lqf.learn.leetCode.hash.containsNearbyDuplicate_219;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1,2,3};
        System.out.println(containsNearbyDuplicate(nums,2));
    }
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums== null ||nums.length == 0) {
            return false;
        }
        for(int i=0;i<nums.length;i++) {
            for(int j=i+1;j<=i+k && j<nums.length;j++) {
                if(nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean containsNearbyDuplicate2(int[] nums, int k) {
        if(nums== null ||nums.length == 0) {
            return false;
        }
        //key:值    value：序号
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++) {
            if(map.containsKey(nums[i])) {
                if(i- map.get(nums[i]) <=k) {
                    return true;
                }
            }
            map.put(nums[i],i);
        }
        return false;
    }

    public static boolean containsNearbyDuplicate3(int[] nums, int k) {
        if(nums== null ||nums.length == 0) {
            return false;
        }
        //key:值    value：序号
        Set<Integer> set = new HashSet<Integer>();
        for(int i=0;i<nums.length;i++) {
            if(set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
            if(set.size()>k) {
              set.remove(nums[i-k]);
            }
        }
        return false;
    }
}
