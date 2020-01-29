package org.lqf.learn.leetCode.greedy.eraseOverlapIntervals_435;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public static void main(String[] args) {

    }
    public int eraseOverlapIntervals(int[][] intervals) {
        int len = intervals.length;
        if(len==0) {
            return 0;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
        int count = 1;
        int x_end = intervals[0][1];
        for(int i=1;i<len;i++) {
            int start = intervals[i][0];
            if(start >=x_end) {
                count++;
                x_end = intervals[i][1];
            }
        }
        return len-count;
    }
}
