package org.lqf.learn.leetCode.bfsAndDfs.maxAreaOfIsland_695;

public class Solution {
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
    static int max = 0;
    static boolean[][] visited;
    public static int maxAreaOfIsland(int[][] grid) {
        visited = new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                if(grid[i][j] == 1) {
                    int count = DFS(grid,i,j,0);
                    max = Math.max(count,max);
                }
            }
        }
        return max;
    }
    public static int DFS(int[][] grid,int i,int j,int count){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || visited[i][j] || grid[i][j]==0) {
            return count;
        }
        visited[i][j] = true;
        count =DFS(grid,i+1,j,count);
        count =DFS(grid,i-1,j,count);
        count =DFS(grid,i,j+1,count);
        count =DFS(grid,i,j-1,count);
        return count+1;
    }
}
