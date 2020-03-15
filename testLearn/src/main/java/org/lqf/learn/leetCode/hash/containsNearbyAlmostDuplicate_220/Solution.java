package org.lqf.learn.leetCode.hash.containsNearbyAlmostDuplicate_220;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {2,2};
        System.out.println(containsNearbyAlmostDuplicate(nums,3,0));
    }
    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k,int t) {
        if(nums== null ||nums.length == 0) {
            return false;
        }

        for(int i=0;i<nums.length;i++) {
            for(int j=i+1;j<=i+k && j<nums.length;j++) {
                if(Math.abs((long)nums[i] - nums[j]) <= t) {
                    return true;
                }
            }
        }
        return false;
    }
    //treeSet
    public static boolean containsNearbyAlmostDuplicate2(int[] nums, int k,int t) {
        if(nums== null ||nums.length == 0 || t<0) {
            return false;
        }
        //key:值    value：序号
        TreeSet<Integer> treeSet = new TreeSet<>();
        for(int i=0;i<nums.length;i++) {
            //找到离他最近的比他大的数
            Integer small = treeSet.floor(nums[i]);
            if(null != small && Long.valueOf(nums[i]) - Long.valueOf(small) <=t) {
                return true;
            }
            //找到离他最近的比他小的数
            Integer biger = treeSet.ceiling(nums[i]);
            if(null != biger && Long.valueOf(biger) - Long.valueOf(nums[i]) <=t) {
                return true;
            }
            treeSet.add(nums[i]);
            if(treeSet.size()>k) {
                treeSet.remove(nums[i-k]);
            }
        }
        return false;
    }
    //桶
    public static boolean containsNearbyAlmostDuplicate3(int[] nums, int k,int t) {
        if(nums== null ||nums.length == 0 || t<0) {
            return false;
        }
        Map<Long,Long> map = new HashMap<>();
        long w = (long)t+1;
        for(int i=0;i<nums.length;i++) {
            long id = getId(nums[i],w);
            if(null != map.get(id)) {
                return true;
            }
            if(null != map.get(id-1) && Math.abs(nums[i] - map.get(id-1))< w) {
                return true;
            }
            if(null != map.get(id+1) && Math.abs(map.get(id+1) - nums[i])< w) {
                return true;
            }
            map.put(id,(long)nums[i]);
            if(i >= k) {
                map.remove(getId(nums[i-k],w));
            }
        }
        return false;
    }

    private static long getId(int num, long w) {
        return num<0?(num+1)/w - 1:num/w;
    }
}
