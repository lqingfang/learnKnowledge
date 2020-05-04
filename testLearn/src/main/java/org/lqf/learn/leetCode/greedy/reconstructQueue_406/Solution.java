package org.lqf.learn.leetCode.greedy.reconstructQueue_406;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        int[][] people = new int[][]{{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
        System.out.println(Arrays.deepToString(reconstructQueue(people)));
    }
    public static int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people,(o1,o2) ->{
            if(o1[0] != o2[0]) {
                return o2[0] - o1[0];
            }else {
                return o1[1] - o2[1];
            }
        });
        System.out.println(Arrays.deepToString(people));
        List<int[]> list = new ArrayList<>();
        for(int[] p:people) {
            list.add(p[1],p);
        }
        return list.toArray(new int[people.length][2]);
    }
}
