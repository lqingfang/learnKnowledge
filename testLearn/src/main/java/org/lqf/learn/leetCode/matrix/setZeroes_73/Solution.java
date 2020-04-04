package org.lqf.learn.leetCode.matrix.setZeroes_73;

import java.util.Arrays;

/**
 * 1、记录第一行，第一列是否有0
 * 2、有0的将 所在的第一行，第一列的位置 置0
 * 3、将第一行，第一列为0 的所在行，或列 置0
 * 4、步骤一，第一行，第一列，原来有0的置0
 */
public class Solution {
    public static void main(String[] args) {
        int[][] matrix = {{1,0,3}};
        setZeroes(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
    public static void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        boolean firstRow = false;
        boolean firstCol = false;
        for(int i=0;i<col;i++) {
            if(matrix[0][i] == 0) {
                firstRow = true;
                break;
            }
        }
        for(int i=0;i<row;i++) {
            if(matrix[i][0] == 0) {
                firstCol = true;
                break;
            }
        }
        for(int i=1;i<row;i++) {
            for(int j=1;j<col;j++) {
                if(matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        for(int i=1;i<row;i++) {
            for(int j=1;j<col;j++) {
                if(matrix[0][j] == 0 || matrix[i][0]==0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if(firstRow) {
            for(int i=0;i<col;i++) {
                matrix[0][i]=0;
            }
        }
        if(firstCol) {
            for(int i=0;i<row;i++) {
                matrix[i][0]=0;
            }
        }
    }
}
