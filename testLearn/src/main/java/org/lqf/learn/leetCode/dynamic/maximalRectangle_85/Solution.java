package org.lqf.learn.leetCode.dynamic.maximalRectangle_85;

public class Solution {
    public static void main(String[] args) {
        char[][] matrix = {
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        };
        System.out.println(maximalRectangle(matrix));
    }
    public static int maximalRectangle(char[][] matrix) {
        int res = 0;
        int[][][] vvv = new int[matrix.length][matrix[0].length][2];
        for (int i = 0; i < matrix[0].length; i++) {
            vvv[0][i][0] = matrix[0][i] - 48;
        }
        for (int j = 0; j < matrix.length; j++) {
            vvv[j][0][1] = matrix[j][0] - 48;
        }

        for(int i=1;i<matrix.length;i++) {
            for(int j=0;j<matrix[0].length;j++) {
                if(matrix[i][j] == '0') {
                    continue;
                }
                if(j>=1 && matrix[i][j-1] == '1'){
                    vvv[i][j][0] = Math.max(vvv[i][j-1][0]+1,1);
                }
                if(matrix[i-1][j] == '1') {
                    vvv[i][j][1] = Math.max(vvv[i-1][j][1]+1,1);
                }
                int len = vvv[i][j][0];
                for(int k= i;k>i-vvv[i][j][1];--k) {
                    len = Math.min(len,vvv[k][j][0]);
                    res = Math.max(res,len*(i-k+1));
                }
                res = Math.max(res,Math.max(vvv[i][j][0],vvv[i][j][1]));
            }
        }
        return res;
    }
}
