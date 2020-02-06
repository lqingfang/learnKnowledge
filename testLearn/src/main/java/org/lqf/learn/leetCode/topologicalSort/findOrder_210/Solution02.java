package org.lqf.learn.leetCode.topologicalSort.findOrder_210;

import java.util.Arrays;

/**
 * 深度遍历
 */
public class Solution02 {
    public static void main(String[] args) {
        int[][] prerequisites = {{}};
        System.out.println(Arrays.toString(findOrder(1,prerequisites)));
    }
    static int[] order;
    static int index =0;
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        if(numCourses ==0 || null == prerequisites|| prerequisites.length ==0){
            return new int[]{};
        }
        if(numCourses == 1) {
            return new int[]{0};
        }
        order = new int[numCourses];
        int[] flag = new int[numCourses];
        int[][] preClss = new int[numCourses][numCourses];
        for(int[] pc:prerequisites) {
            preClss[pc[0]][pc[1]]++;
        }
        for(int i=0;i<numCourses;i++) {
            if(!dfs(numCourses,flag,i,preClss)) {
                return new int[]{};
            }
        }
        return order;
    }

    private static boolean dfs(int numCourses,int[] flag, int i, int[][] preClss) {
        if(flag[i] == -1) {
            return true;
        }
        if(flag[i] == 1) {
            return false;
        }
        flag[i] = 1;
        for(int j=0;j<numCourses;j++) {
            if(preClss[i][j] == 1 && !dfs(numCourses,flag,j,preClss)) {
                return false;
            }
        }
        order[index++] = i;
        flag[i] = -1;
        return true;
    }
}
