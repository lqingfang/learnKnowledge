package org.lqf.learn.leetCode.bfsAndDfs.updateMatrix_542;

import java.util.Arrays;

/**
 * dfs   还不对
 */
public class Solution02 {
    public static void main(String[] args) {
//        int[][] matrix = new int[][]{
//                {0, 0, 0},
//                {0, 1, 0},
//                {1, 1, 1}
//        };
//        int[][] matrix = new int[][]{
//                {0, 1, 0},
//                {0, 1, 0},
//                {0, 1, 0},
//                {0, 1, 0},
//                {0, 1, 0}
//        };
        int[][] matrix = new int[][]{
                {1,0,1,1,0,0,1,0,0,1},
                {0,1,1,0,1,0,1,0,1,1},
                {0,0,1,0,1,0,0,1,0,0},
                {1,0,1,0,1,1,1,1,1,1},
                {0,1,0,1,1,0,0,0,0,1},
                {0,0,1,0,1,1,1,0,1,0},
                {0,1,0,1,0,1,0,0,1,1},
                {1,0,0,0,1,1,1,1,0,1},
                {1,1,1,1,1,1,1,0,1,0},
                {1,1,1,1,0,1,0,0,1,1}
        };
        int[][] res = updateMatrix(matrix);
        for(int[] array:res) {
            System.out.println(Arrays.toString(array));
        }
    }
    static int row;
    static int col;
    static int[][] res;
    public static int[][] updateMatrix(int[][] matrix) {
        row = matrix.length;
        col = matrix[0].length;
        res = new int[row][col];
        for(int i=0;i<row;i++) {
            for(int j=0;j<col;j++) {
                if(matrix[i][j] == 0){
                    res[i][j] = 0;
                }else {
                    int length = dfs(matrix,i,j,0);
                    res[i][j] = length;
                }
            }
        }
        return res;
    }

    private static int dfs(int[][] matrix, int i, int j,int len) {
        if(i<0 || j<0 || i>=row || j>=col) {
            return Integer.MAX_VALUE;
        }
        if(matrix[i][j] == 0) {
            return len;
        }
        if(i-1>=0 && matrix[i-1][j] == 0) {
            return len+1;

        }
        if(i+1 < row && matrix[i+1][j] == 0) {
            return len+1;
        }
        if(j-1>=0 && matrix[i][j-1] == 0) {
            return len+1;
        }
        if(j+1 < col && matrix[i][j+1] == 0) {
            return len+1;
        }

        int a = Integer.MAX_VALUE, b = Integer.MAX_VALUE, c = Integer.MAX_VALUE, d = Integer.MAX_VALUE;
        if(i-1 >= 0) {
            a = dfs(matrix, i - 1, j, len+1);
            //return a;
        }
        if(i+1 < row) {
            b = dfs(matrix,i+1,j,len+1);
            //return b;
        }
        if(j-1>=0) {
            c = dfs(matrix,i,j-1,len+1);
            //return c;
        }
        if(j+1 < col) {
            d = dfs(matrix,i,j+1,len+1);
            //return d;
        }
        return Math.min(a,Math.min(b,Math.min(c,d)));
    }
}
