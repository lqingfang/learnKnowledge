package org.lqf.learn.leetCode.matrix.matrixReshape_566;

public class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int row = nums.length;
        int col = nums[0].length;
        if(row*col != r*c) {
            return nums;
        }
        int[][] newMatrix = new int[r][c];
        int p=0,q=0;
        for(int i=0;i<row;i++) {
            for(int j=0;j<col;j++) {
                newMatrix[p][q] = nums[i][j];
                q++;
                if(q == c) {
                    p=p+1;
                    q = 0;
                }
            }
        }
        return newMatrix;
    }
}
