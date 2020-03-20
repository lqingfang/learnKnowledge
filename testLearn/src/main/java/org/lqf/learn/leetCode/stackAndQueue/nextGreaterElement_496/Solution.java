package org.lqf.learn.leetCode.stackAndQueue.nextGreaterElement_496;

public class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int len_1 = nums1.length;
        int len_2 = nums2.length;
        int[] res = new int[len_1];
        for(int i=0;i<len_1;i++) {
            for(int j=0;j<len_2;j++) {
                if(nums1[i] == nums2[j]) {
                    res[i] = findNextMax(nums1[i],j,nums2);
                }
            }
        }
        return res;
    }

    private int findNextMax(int a, int index, int[] nums2) {
        for(int i= index;i<nums2.length;i++) {
            if(nums2[i] > a) {
                return nums2[i];
            }
        }
        return -1;
    }


}
