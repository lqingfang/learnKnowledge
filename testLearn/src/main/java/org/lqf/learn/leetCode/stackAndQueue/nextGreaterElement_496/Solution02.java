package org.lqf.learn.leetCode.stackAndQueue.nextGreaterElement_496;

import java.util.HashMap;
import java.util.Map;

public class Solution02 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer,Integer> nextMaxMap = new HashMap<>();
        int[] res = new int[nums1.length];
        for(int i=0;i<nums2.length;i++) {
            int max = getNextMax(nums2[i],i,nums2);
            nextMaxMap.put(nums2[i],max);
        }
        for(int j=0;j<nums1.length;j++) {
            res[j] = nextMaxMap.get(nums1[j]);
        }
        return res;
    }

    public int getNextMax(int a, int index, int[] nums2) {
        for(int i= index;i<nums2.length;i++) {
            if(nums2[i] > a) {
                return nums2[i];
            }
        }
        return -1;
    }
}
