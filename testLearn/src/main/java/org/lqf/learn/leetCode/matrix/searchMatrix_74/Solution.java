package org.lqf.learn.leetCode.matrix.searchMatrix_74;

public class Solution {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,1}};
        System.out.println(searchMatrix(matrix,2));
    }
    public static boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length==0) {
            return false;
        }
        int row = matrix.length;
        int col = matrix[0].length;

        int left = 0;
        int right = row*col -1;
        int pivotIdx,pivotElement;
        while (left <= right) {
            pivotIdx = (left+right)>>1;
            pivotElement = matrix[pivotIdx/col][pivotIdx%col];
            if(pivotElement == target) {
                return true;
            }
            if(pivotElement < target) {
                left = pivotIdx+1;
            }else {
                right = pivotIdx-1;
            }
        }
        return false;
    }
}
