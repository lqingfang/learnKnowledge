package org.lqf.learn.leetCode.bfsAndDfs.maxAreaOfIsland_695;

public class Solution02 {
    public static void main(String[] args) {
        int[][] grid = {
                {0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}
        };
        System.out.println(maxAreaOfIsland(grid));
    }
    static int res;
    static int rum;
    static int col;
    static int[][] visited;
    public static int maxAreaOfIsland(int[][] grid) {
        res = 0;
        rum = grid.length;
        col = grid[0].length;
        visited = new int[rum][col];
        for(int i=0;i<rum;i++){
            for(int j=0;j<col;j++) {
                if(grid[i][j] == 1) {
                    int count = dfs(grid,i,j,0);
                    res = Math.max(count,res);
                }
            }
        }
        return res;
    }

    private static int dfs(int[][] grid, int i, int j,int count) {
        if(i>=rum || j>=col ||i<0|| j<0||visited[i][j]==1 ||grid[i][j] == 0) {
            return count;
        }
        visited[i][j] = 1;
        count = dfs(grid,i-1,j,count);
        count = dfs(grid,i,j-1,count);
        count = dfs(grid,i+1,j,count);
        count = dfs(grid,i,j+1,count);
        return count+1;
    }
}
