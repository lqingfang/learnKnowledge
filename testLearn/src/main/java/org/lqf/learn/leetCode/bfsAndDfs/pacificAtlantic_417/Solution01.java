package org.lqf.learn.leetCode.bfsAndDfs.pacificAtlantic_417;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution01 {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {3,3,3,3,3,3},
                {3,0,3,3,0,3},
                {3,3,3,3,3,3}
        };
        System.out.println(pacificAtlantic(matrix));
    }
    static List<List<Integer>> res;
    static int row;
    static int col;
    static boolean[][] visited;
    static boolean pacific;
    static boolean atlantic;
    public static List<List<Integer>> pacificAtlantic(int[][] matrix) {
        if(null == matrix || matrix.length == 0){
            return Collections.emptyList();
        }
        res = new ArrayList<>();
        row = matrix.length;
        col = matrix[0].length;
        visited = new boolean[row][col];
        for(int i=0;i<row;i++) {
            for(int j=0;j<col;j++) {
                //太平洋
                pacific = false;
                //大西洋
                atlantic = false;
                dfs(matrix,i,j);
                if(pacific && atlantic) {
                    res.add(Arrays.asList(i,j));
                }
            }
        }
        return res;
    }

    private static void dfs(int[][] matrix, int i, int j) {
        if(i<0 || j<0 || i>=row || j>=col) {
            return;
        }
        if(i == 0 || j==0) {
            pacific =  true;
        }
        if(i == row-1 || j==col-1) {
            atlantic = true;
        }
        if(pacific && atlantic) {
            return;
        }
        visited[i][j] = true;
        if(i+1 < row )
            if(matrix[i+1][j] <= matrix[i][j] && !visited[i+1][j]) {
            dfs(matrix,i+1,j);
        }
        if(i-1>=0 )
            if(matrix[i-1][j]<=matrix[i][j] && !visited[i-1][j]) {
            dfs(matrix,i-1,j);
        }
        if(j+1 < col )
            if(matrix[i][j+1] <= matrix[i][j] && !visited[i][j+1]) {
            dfs(matrix,i,j+1);
        }
        if(j-1>=0 )
            if(matrix[i][j-1]<=matrix[i][j] && !visited[i][j-1]) {
            dfs(matrix,i,j-1);
        }
        visited[i][j] = false;
    }
}
