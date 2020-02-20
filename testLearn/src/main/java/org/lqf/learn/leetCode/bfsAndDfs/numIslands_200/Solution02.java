package org.lqf.learn.leetCode.bfsAndDfs.numIslands_200;

public class Solution02 {
    public static void main(String[] args) {
                char[][] grid = new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        System.out.println(numIslands(grid));
    }
    static int res;
    static int rum;
    static int col;
    static boolean[][] visited;
    public static int numIslands(char[][] grid) {
        if(null == grid || grid.length ==0) {
            return 0;
        }
        res = 0;
        rum = grid.length;
        col = grid[0].length;
        visited = new boolean[rum][col];
        for(int i=0;i<rum;i++) {
            for(int j=0;j<col;j++) {
                if(grid[i][j] == '1' && !visited[i][j]) {
                    res++;
                    dfs(grid,i,j);
                }
            }
        }
        return res;
    }

    private static void dfs(char[][] grid, int i, int j) {
        if(i<0 || j<0 || i>=rum || j>=col || visited[i][j] || grid[i][j] == '0') {
            return;
        }
        visited[i][j] = true;
        dfs(grid,i-1,j);
        dfs(grid,i+1,j);
        dfs(grid,i,j-1);
        dfs(grid,i,j+1);
    }
}
