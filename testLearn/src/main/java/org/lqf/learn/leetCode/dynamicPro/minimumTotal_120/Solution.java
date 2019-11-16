package org.lqf.learn.leetCode.dynamicPro.minimumTotal_120;

public class Solution {
    public static void main(String[] args) {
        int[][] triangle = {
                {2},
                {3,4},
                {6,5,7},
                {4,2,8,3},
                {9,7,6,8,1}
        };
        System.out.println(minimumTotal(triangle));
    }
    public static int minimumTotal(int[][] triangle) {
        int[] min = new int[triangle.length+1];
        for(int i = triangle.length-1;i>=0;i--) {
            for(int j=0;j<triangle[i].length;j++) {
                min[j] = triangle[i][j] + Math.min(min[j],min[j+1]);
            }
        }
        return min[0];
    }
}
