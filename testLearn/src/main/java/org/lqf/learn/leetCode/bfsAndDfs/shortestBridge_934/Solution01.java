package org.lqf.learn.leetCode.bfsAndDfs.shortestBridge_934;

import java.util.LinkedList;
import java.util.Queue;

public class Solution01 {
    public static void main(String[] args) {
//        int[][] A = new int[][]{
//                {1,1,1,1,1},
//                {1,0,0,0,1},
//                {1,0,1,0,1},
//                {1,0,0,0,1},
//                {1,1,1,1,1}};
        int[][] A = new int[][]{
                {0,1},
                {1,0}
        };
        System.out.println(shortestBridge(A));
    }
    static Queue<int[]> queue;
    static int row;
    static int col;
    static boolean[][] visited;
    public static int shortestBridge(int[][] A) {
        if(A==null || A[0].length ==0) {
            return 0;
        }
        row = A.length;
        col = A[0].length;
        queue = new LinkedList<>();
        visited = new boolean[row][col];
        boolean find = false;
        for(int i=0;i<row;i++) {
            for(int j=0;j<col;j++) {
                if(A[i][j] == 1) {
                    dfs(A,i,j);
                    find = true;
                    break;
                }
            }
            if(find) {
                break;
            }
        }
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0;i<size;i++) {
                int[] poll = queue.remove();
                int poI = poll[0];
                int poJ = poll[1];
                if(poI-1>=0) {
                    if(A[poI-1][poJ] == 1) {
                        return step;
                    }else if(A[poI-1][poJ] == 0) {
                        A[poI-1][poJ] = 2;
                        queue.add(new int[]{poI-1,poJ});
                    }
                }
                if(poJ-1>=0) {
                    if(A[poI][poJ-1] == 1) {
                        return step;
                    }else if(A[poI][poJ-1] == 0) {
                        A[poI][poJ-1] = 2;
                        queue.add(new int[]{poI,poJ-1});
                    }
                }
                if(poI+1 < row) {
                    if(A[poI+1][poJ] == 1) {
                        return step;
                    }else if(A[poI+1][poJ] == 0) {
                        A[poI+1][poJ] = 2;
                        queue.add(new int[]{poI+1,poJ});
                    }
                }
                if(poJ+1 < col) {
                    if(A[poI][poJ+1] == 1) {
                        return step;
                    }else if(A[poI][poJ+1] == 0) {
                        A[poI][poJ+1] = 2;
                        queue.add(new int[]{poI,poJ+1});
                    }
                }
            }
            step++;
        }
        return -1;
    }


    private static void dfs(int[][] A, int i, int j) {
        if(i<0 || j<0 || i>=row || j>=col || A[i][j]==2 || A[i][j]==0) {
            return;
        }
        A[i][j] = 2;
        queue.add(new int[]{i,j});
        dfs(A,i-1,j);
        dfs(A,i,j-1);
        dfs(A,i+1,j);
        dfs(A,i,j+1);
    }
}
