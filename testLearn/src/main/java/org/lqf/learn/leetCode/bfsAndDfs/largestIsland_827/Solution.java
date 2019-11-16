package org.lqf.learn.leetCode.bfsAndDfs.largestIsland_827;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.largestIsland(new int[][]{
                {1,1,0,0},
                {0,1,0,0},
                {1,1,0,0},
                {0,0,1,1}
        }));
    }

    int[] area;
    int m;
    int n;
    int currentArea;
    public int largestIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        area = new int[m*n+2];
        int index = 2;
        int maxArea = 0;
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                currentArea = 0;
                dfs(grid,index,i,j);
                area[index++] = currentArea;
                maxArea = Math.max(maxArea,currentArea);
            }
        }

        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(grid[i][j] == 0) {
                    maxArea = Math.max(maxArea,changeSea(grid,i,j));
                }
            }
        }
        return maxArea;
    }

    private int changeSea(int[][] grid, int i, int j) {
        Set<Integer> set = new HashSet();
        int areaSum = 1;
        if(i-1>=0) {
            set.add(grid[i-1][j]);
        }
        if(i+1 < m) {
            set.add(grid[i+1][j]);
        }
        if(j-1>=0) {
            set.add(grid[i][j-1]);
        }
        if(j+1<n) {
            set.add(grid[i][j+1]);
        }
        for(Integer color : set) {
            areaSum += area[color];
        }
        return areaSum;
    }

    private void dfs(int[][] grid, int index, int i, int j) {
        if(i<0 || i>=m || j<0 || j>=n || grid[i][j]!=1) {
            return;
        }
        grid[i][j] = index;
        currentArea++;
        dfs(grid,index,i-1,j);
        dfs(grid,index,i+1,j);
        dfs(grid,index,i,j-1);
        dfs(grid,index,i,j+1);
    }

}
