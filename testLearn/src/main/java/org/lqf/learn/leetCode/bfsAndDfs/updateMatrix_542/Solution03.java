package org.lqf.learn.leetCode.bfsAndDfs.updateMatrix_542;

/**
 * dp
 */
public class Solution03 {
    public static void main(String[] args) {

    }
    public int[][] updateMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] res = new int[row][col];
        for(int i=0;i<row;i++) {
            for(int j=0;j<col;j++) {
                if(matrix[i][j] == 1) {
                    res[i][j] = row+col;
                }
                if(i>0) {
                    res[i][j] = Math.min(res[i][j],res[i-1][j]+1);
                }
                if(j>0) {
                    res[i][j] = Math.min(res[i][j],res[i][j-1]+1);
                }
            }
        }
        for(int i=row-1;i>=0;i--) {
            for(int j=col-1;j>=0;j--) {
                if(i<row-1) {
                    res[i][j] = Math.min(res[i][j],res[i+1][j]+1);
                }
                if(j<col-1) {
                    res[i][j] = Math.min(res[i][j],res[i][j+1]+1);
                }
            }
        }
        return res;
    }
}
