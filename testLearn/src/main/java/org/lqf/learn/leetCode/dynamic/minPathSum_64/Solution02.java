package org.lqf.learn.leetCode.dynamic.minPathSum_64;

/**
 * 递归，超时
 */
public class Solution02 {
    public static void main(String[] args) {

    }
    public int minPathSum(int[][] grid) {
        int[][] df = new int[grid.length][grid[0].length];
        for(int i=grid.length-1;i>=0;i--) {
            for(int j=grid[0].length-1;j>=0;j--) {
                if(i==grid.length-1 && j<grid[0].length-1) {
                    df[i][j] = grid[i][j]+df[i][j+1];
                }else if(i < grid.length-1 && j==grid[0].length-1) {
                    df[i][j] = grid[i][j]+df[i+1][j];
                }else if(i < grid.length-1 && j<grid[0].length-1) {
                    df[i][j] = grid[i][j] + Math.min(df[i][j+1],df[i+1][j]);
                }else {
                    df[i][j] = grid[i][j];
                }
            }
        }
        return df[0][0];
    }
}
