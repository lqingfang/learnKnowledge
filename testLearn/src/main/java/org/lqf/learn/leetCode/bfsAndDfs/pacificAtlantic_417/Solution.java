package org.lqf.learn.leetCode.bfsAndDfs.pacificAtlantic_417;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {3,3,3,3,3,3},
                {3,0,3,3,0,3},
                {3,3,3,3,3,3}
        };
        System.out.println(pacificAtlantic(matrix));
    }

    static boolean pacific = false;
    static boolean atlantic = false;
    static boolean[][] visted;
    public static List<List<Integer>> pacificAtlantic(int[][] matrix) {
        if(null == matrix || matrix.length == 0) {
            return Collections.emptyList();
        }
        visted = new boolean[matrix.length][matrix[0].length];
        List<List<Integer>> result = new ArrayList<>();
        for(int i =0;i<matrix.length;i++) {
            for(int j=0;j<matrix[0].length;j++) {
                pacific = false;
                atlantic = false;
                dfs(matrix,i,j);
                if(pacific && atlantic) {
                    result.add(Arrays.asList(i,j));
                }
            }
        }
        return result;
    }

    private static void dfs(int[][] matrix, int i, int j) {
        if(i<0 || i>=matrix.length || j<0 || j>= matrix[0].length) {
            return;
        }
        if(i==0 || j==0) {
            pacific = true;
        }
        if(i == matrix.length-1 || j == matrix[0].length-1) {
            atlantic = true;
        }
        if(pacific && atlantic) {
            return;
        }
        visted[i][j] = true;
        if(i+1 <matrix.length) {
            if(matrix[i+1][j] <=matrix[i][j] && !visted[i+1][j]) {
                dfs(matrix,i+1,j);
            }
        }
        if(i-1>=0){
            if(matrix[i-1][j] <=matrix[i][j] && !visted[i-1][j]) {
                dfs(matrix,i-1,j);
            }
        }
        if(j+1 <matrix[0].length){
            if(matrix[i][j+1] <=matrix[i][j] && !visted[i][j+1]) {
                dfs(matrix,i,j+1);
            }
        }
        if(j-1>=0){
            if(matrix[i][j-1] <=matrix[i][j] && !visted[i][j-1]) {
                dfs(matrix,i,j-1);
            }
        }

        visted[i][j] = false;
    }


}
