package org.lqf.learn.leetCode.bfsAndDfs.findCircleNum_547;

public class Solution02 {
    public static void main(String[] args) {
        int[][] M = new int[][]{
                {1,0,0,1},
                {0,1,1,0},
                {0,1,1,1},
                {1,0,1,1}
        };
        System.out.println(findCircleNum(M));
    }
    public static int findCircleNum(int[][] M) {
        int count = 0;
        if(M == null || M.length == 0) {
            return 0;
        }
        for(int i = 0;i< M.length;i++) {
                if(M[i][i] == 1) {
                    dfs(M,i,i);
                    count++;
                }
        }
        return count;
    }
    private static void dfs(int[][] M, int i, int j) {
        if(i<0 || i>=M.length || j<0 || j>=M[0].length || M[i][j] == 0) {
            return;
        }

        M[i][j] = 0;
        M[j][i] = 0;
        for(int k=0;k<M[0].length;k++) {
            dfs(M,j,k);
        }
    }
}
