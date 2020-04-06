package org.lqf.learn.leetCode.array.maxChunksToSorted_768;

public class Solution {
    //核心：下一分组的最小值，大于当前分组的最大值，则可以独立。
    public int maxChunksToSorted(int[] arr) {
        int len = arr.length;
        int[] max = new int[len];
        max[0] = arr[0];
        for(int i=1;i<len;i++) {
            max[i] = Math.max(arr[i],max[i-1]);
        }
        int res = 0;
        int min = Integer.MAX_VALUE;
        for(int i=len-1;i>=0;i--) {
            if(min >= max[i]) {
                res++;
            }
            min = Math.min(min,arr[i]);
        }
        return res;
    }
}
