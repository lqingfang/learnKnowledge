package org.lqf.learn.leetCode.dynamic.minPathSum_64;

/**
 * 递归，超时
 */
public class Solution {
    public static void main(String[] args) {

    }
    public int minPathSum(int[][] grid) {
        return calcuate(grid,0,0);
    }

    private static int calcuate(int[][] grid, int i, int j) {
        if(i == grid.length || j== grid[0].length) {
            return Integer.MAX_VALUE;
        }
        if(i == grid.length-1 && j==grid[0].length-1) {
            return grid[i][j];
        }
        return grid[i][j] + Math.min(calcuate(grid,i+1,j),calcuate(grid,i,j+1));
    }
}
