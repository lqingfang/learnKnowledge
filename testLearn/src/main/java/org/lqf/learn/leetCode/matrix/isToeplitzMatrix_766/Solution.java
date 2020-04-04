package org.lqf.learn.leetCode.matrix.isToeplitzMatrix_766;

public class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        for(int i=1;i<matrix.length;i++) {
            for(int j=1;j<matrix[0].length;j++) {
                if(matrix[i][j] != matrix[i-1][j-1]) {
                    return false;
                }
            }
        }
        return true;
    }
}
