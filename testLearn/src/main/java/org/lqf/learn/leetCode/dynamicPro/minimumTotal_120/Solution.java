package org.lqf.learn.leetCode.dynamicPro.minimumTotal_120;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
//        int[][] triangle = {
//                {2},
//                {3,4},
//                {6,5,7},
//                {4,2,8,3},
//                {9,7,6,8,1}
//        };
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(new ArrayList<>(Arrays.asList(2)));
        triangle.add(new ArrayList<>(Arrays.asList(3,4)));
        triangle.add(new ArrayList<>(Arrays.asList(6,5,7)));
        triangle.add(new ArrayList<>(Arrays.asList(4,2,8,3)));
        System.out.println(minimumTotal(triangle));
    }
    public static int minimumTotal(List<List<Integer>> triangle) {
        int[] min = new int[triangle.size()+1];
        for(int i = triangle.size()-1;i>=0;i--) {
            for(int j=0;j<triangle.get(i).size();j++) {
                min[j] = triangle.get(i).get(j) + Math.min(min[j],min[j+1]);
            }
        }
        return min[0];
    }
}
