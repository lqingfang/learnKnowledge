package org.lqf.learn.leetCode.matrix.searchMatrix_240;

/**
 * 走台阶
 */
public class Solution {
    public static void main(String[] args) {
        int[][] matrix = {
                {1,   4,  7, 11, 15},
                {2,   5,  8, 12, 19},
                {3,   6,  9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        System.out.println(searchMatrix(matrix,5));
    }
    public static boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix[0].length == 0) {
            return false;
        }
        int row = matrix.length;
        int col = matrix[0].length;

        int curRow = 0;
        int curCol = col-1;
        while (curRow < row && curCol >=0) {
            if(matrix[curRow][curCol] == target) {
                return true;
            }
            if(matrix[curRow][curCol] < target) {
                curRow++;
            }else if(matrix[curRow][curCol] > target) {
                curCol--;
            }
        }
        return false;
    }

}
