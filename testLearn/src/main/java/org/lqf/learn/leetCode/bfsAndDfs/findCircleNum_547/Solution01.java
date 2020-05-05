package org.lqf.learn.leetCode.bfsAndDfs.findCircleNum_547;

public class Solution01 {
    public static void main(String[] args) {
//        int[][] M = new int[][]{
//                {1,0,0,1},
//                {0,1,1,0},
//                {0,1,1,1},
//                {1,0,1,1}
//        };
        int[][] M = new int[][]{
                {1,0,0},
                {0,1,1},
                {0,0,1}
        };
        System.out.println(findCircleNum(M));
    }
    static int row;
    static int col;
    static int res;
    static boolean[][] visited;
    public static int findCircleNum(int[][] M) {
        row = M.length;
        col = M[0].length;
        visited = new boolean[row][col];
        res = 0;
        //对角线对称
        for(int i=0;i<row;i++) {
            if(visited[i][i]) {
                continue;
            }
            res++;
            dfs(M,i,i,col);
        }
        return res;
    }

    private static void dfs(int[][] m, int i,int j,int col) {
        if(visited[i][j] || m[i][j] == 0) {
            return;
        }
        visited[i][j] = true;
        visited[j][i] = true;
        for(int k=0;k<col;k++) {
            dfs(m,j,k,col);
        }
    }
}
