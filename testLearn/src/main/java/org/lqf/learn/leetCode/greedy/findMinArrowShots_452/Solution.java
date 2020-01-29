package org.lqf.learn.leetCode.greedy.findMinArrowShots_452;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public static void main(String[] args) {

    }
    public int findMinArrowShots(int[][] points) {
        int len = points.length;
        if(len==0) {
            return 0;
        }
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
        int count = 1;
        int x_end = points[0][1];
        for(int i=1;i<len;i++) {
            int x_start = points[i][0];
            if(x_start>x_end) {
                count++;
                x_end = points[i][1];
            }
        }
        return count;
    }
}
