package org.lqf.learn.leetCode.array.maxChunksToSorted_769;

public class Solution01 {
    public int maxChunksToSorted(int[] arr) {
        int res = 0;
        int max = 0;
        for(int i=0;i<arr.length;i++) {
            max = Math.max(max,arr[i]);
            //如果当前位置不需要移动，则可以独立出来
            if(max == i) {
                res++;
            }
        }
        return res;
    }
}
