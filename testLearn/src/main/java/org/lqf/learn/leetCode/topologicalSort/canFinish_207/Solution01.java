package org.lqf.learn.leetCode.topologicalSort.canFinish_207;

import java.util.LinkedList;

/**
 * 层次遍历
 */
public class Solution01 {
    public static void main(String[] args) {
        int[][] prerequisites = {{2,3}};
        System.out.println(canFinish(4,prerequisites));
    }
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] preClass = new int[numCourses];
        //需要前置条件的++
        for(int[] pre:prerequisites) {
            preClass[pre[0]]++;
        }
        //不需要前置条件的放到队列，说明可以先上的课
        LinkedList<Integer> queue = new LinkedList();
        for(int i=0;i<numCourses;i++){
            if(preClass[i] == 0) {
                queue.addLast(i);
            }
        }
        while (!queue.isEmpty()) {
            Integer pre = queue.removeFirst();
            //标识课是否上完
            numCourses--;
            for(int[] cls :prerequisites) {
                if(cls[1] == pre) {
                    //如果这次队列出来的是其它的必修课，则该课程的前置条件--
                    //如果该课程的前置条件为0，放入队列
                    preClass[cls[0]]--;
                    if(preClass[cls[0]] == 0) {
                        queue.addLast(cls[0]);
                    }
                }
            }
        }
        return numCourses==0;
    }
}
