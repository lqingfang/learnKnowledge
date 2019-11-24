package org.lqf.learn.leetCode.bfsAndDfs.updateMatrix_542;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[][] matrix = new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        int[][] matrix = new int[][]{{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
        System.out.println(Arrays.deepToString(solution.updateMatrix(matrix)));
    }
    public int[][] updateMatrix(int[][] matrix) {
        if(matrix == null || matrix.length ==0) {
            return null;
        }
        int[][] result = new int[matrix.length][matrix[0].length];
        for(int i =0;i<matrix.length;i++) {
            for(int j=0;j<matrix[0].length;j++) {
                if(matrix[i][j] == 1) {
                    int dis = dfs(matrix,i,j);
                    result[i][j] = dis;
                }
            }
        }
        return result;
    }

    private int dfs(int[][] matrix, int i, int j) {
        if(i<0 || i>=matrix.length || j<0 || j>=matrix[0].length) {
            return 0;
        }
        int dis=0;
        Queue<int[]> queue = new LinkedList();
        queue.offer(new int[]{i,j});
        while (!queue.isEmpty()) {
            int size = queue.size();
            dis++;
            for(int k=0;k<size;k++) {
                int[] poll = queue.poll();
                int m = poll[0];
                int n = poll[1];
                if(m+1<matrix.length) {
                    if(matrix[m+1][n] == 0) {
                        return dis;
                    }
                    queue.offer(new int[]{m+1,n});
                }
                if(m-1>=0) {
                    if(matrix[m-1][n] == 0) {
                        return dis;
                    }
                    queue.offer(new int[]{m-1,n});
                }
                if(n+1<matrix[0].length) {
                    if(matrix[m][n+1] == 0) {
                        return dis;
                    }
                    queue.offer(new int[]{m,n+1});
                }
                if(n-1>=0) {
                    if(matrix[m][n-1] == 0) {
                        return dis;
                    }
                    queue.offer(new int[]{m,n-1});
                }
            }
        }

        return dis;
    }
}
