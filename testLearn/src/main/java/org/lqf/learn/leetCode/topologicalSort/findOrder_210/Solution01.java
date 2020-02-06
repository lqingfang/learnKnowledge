package org.lqf.learn.leetCode.topologicalSort.findOrder_210;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 层次遍历
 */
public class Solution01 {
    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = new int[][]{
                {1,0}
        };
        System.out.println(Arrays.toString(findOrder(numCourses,prerequisites)));
    }
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] order = new int[numCourses];
        int[] preClass = new int[numCourses];
        for(int[] preC:prerequisites) {
            preClass[preC[0]]++;
        }
        LinkedList<Integer> queue = new LinkedList<>();
        for(int i=0;i<numCourses;i++) {
            if(preClass[i] == 0) {
                queue.addLast(i);
            }
        }
        int index = 0;
        while (!queue.isEmpty()) {
            Integer i = queue.removeFirst();
            order[index++] = i;
            for(int[] preQ:prerequisites) {
                if(preQ[1] == i) {
                    preClass[preQ[0]]--;
                    if(preClass[preQ[0]] == 0) {
                        queue.addLast(preQ[0]);
                    }
                }
            }
        }
        if(index == numCourses) {
            return order;
        }else {
            return new int[0];
        }
    }
}
