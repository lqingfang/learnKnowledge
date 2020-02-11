package org.lqf.learn.leetCode.bfsAndDfs.largestIsland_827;

import java.util.HashSet;
import java.util.Set;

/**
 * dfs
 */
public class Solution01 {
    public static void main(String[] args) {
        int[][] grid = new int[][] {
                {1,0},
                {0,1}
        };
        System.out.println(largestIsland(grid));
    }
    static int currentArea;
    static int[] area;
    static int rowNum;
    static int colNum;
    public static int largestIsland(int[][] grid) {
        rowNum = grid.length;
        colNum = grid[0].length;
        area = new int[rowNum*colNum+2];
        int color = 2;
        int maxArea = 0;
        //对不同区域进行染色
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                currentArea = 0;
                dfs(grid,i,j,color);
                //记录每一块岛屿的面积
                area[color++] = currentArea;
                maxArea = Math.max(maxArea,currentArea);
            }
        }
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                if(grid[i][j] == 0) {
                    maxArea = Math.max(maxArea,changeArea(grid,i,j));
                }
            }
        }
        return maxArea;
    }

    private static int changeArea(int[][] grid, int i, int j) {
        //统计周围的都有哪些颜色
        int areaNum = 1;
        Set<Integer> set = new HashSet<>();
        if(i-1>=0) {
            set.add(grid[i-1][j]);
        }
        if(i+1 < rowNum) {
            set.add(grid[i+1][j]);
        }
        if(j-1 >=0) {
            set.add(grid[i][j-1]);
        }
        if(j+1 < colNum) {
            set.add(grid[i][j+1]);
        }
        for(Integer color:set) {
            areaNum += area[color];
        }
        return areaNum;
    }

    private static void dfs(int[][] grid, int i, int j, int color) {
        if(i>=rowNum || j>=colNum || i<0 || j<0 || grid[i][j] !=1) {
            return;
        }
        currentArea++;
        grid[i][j] = color;
        dfs(grid,i-1,j,color);
        dfs(grid,i+1,j,color);
        dfs(grid,i,j-1,color);
        dfs(grid,i,j+1,color);
    }
}
