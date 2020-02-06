package org.lqf.learn.leetCode.topologicalSort.canFinish_207;

/**
 * 深度遍历
 */
public class Solution02 {
    public static void main(String[] args) {
        int[][] prerequisites = {{2,3}};
        System.out.println(canFinish(4,prerequisites));
    }
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] flag = new int[numCourses];
        int[][] preClss = new int[numCourses][numCourses];
        for(int[] pc:prerequisites) {
            preClss[pc[1]][pc[0]]++;
        }
        for(int i=0;i<numCourses;i++) {
            if(!dfs(numCourses,flag,i,preClss)) {
                return false;
            }
        }
        return true;
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
        flag[i] = -1;
        return true;
    }
}
