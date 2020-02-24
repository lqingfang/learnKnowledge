package org.lqf.learn.leetCode.bfsAndDfs.updateMatrix_542;

import java.util.LinkedList;
import java.util.Queue;

/**
 * bfs
 */
public class Solution01 {
    public static void main(String[] args) {

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
                    int length = bfs(matrix,i,j);
                    res[i][j] = length;
                }
            }
        }
        return res;
    }
    private static int bfs(int[][] matrix, int i, int j) {
        if(i<0 || j<0 || i>=row || j>=col) {
            return 0;
        }
        int dis = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i,j});
        while (!queue.isEmpty()) {
            dis++;
            int size = queue.size();
            for(int k=0;k<size;k++) {
                int[] poll = queue.poll();
                int m = poll[0];
                int n = poll[1];
                if(m+1<row) {
                    if(matrix[m+1][n] == 0) {
                        return dis;
                    }
                    queue.add(new int[]{m+1,n});
                }
                if(m-1 >= 0) {
                    if(matrix[m-1][n] == 0) {
                        return dis;
                    }
                    queue.add(new int[]{m-1,n});
                }
                if(n+1<col) {
                    if(matrix[m][n+1] == 0) {
                        return dis;
                    }
                    queue.add(new int[]{m,n+1});
                }
                if(n-1>=0) {
                    if(matrix[m][n-1] == 0) {
                        return dis;
                    }
                    queue.add(new int[]{m,n-1});
                }
            }
        }
        return dis;
    }
}
