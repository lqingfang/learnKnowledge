package org.lqf.learn.leetCode.bfsAndDfs.shortestBridge_934;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] A = new int[][]{{1,1,1,1,1}, {1,0,0,0,1}, {1,0,1,0,1},
                {1,0,0,0,1}, {1,1,1,1,1}};
        System.out.println(solution.shortestBridge(A));
    }
    boolean[][] visited;
    Queue<int[]> queue = new LinkedList<>();
    int x;
    int y;
    public int shortestBridge(int[][] A) {
        x = A.length;
        y = A[0].length;
        visited = new boolean[x][y];
        getFirstIsland(A);
        return toSecondIsland(A);
    }

    private int toSecondIsland(int[][] A) {
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0;i<size;i++) {
                int[] poll = queue.poll();
                int m = poll[0];
                int n = poll[1];
                if(m-1>=0) {
                    if(A[m-1][n] == 1 && !visited[m-1][n]) {
                        return level;
                    }else {
                        queue.offer(new int[]{m-1,n});
                        visited[m-1][n] = true;
                    }
                }
                if(m+1 < x) {
                    if(A[m+1][n] == 1 && !visited[m+1][n]) {
                        return level;
                    }else {
                        queue.offer(new int[]{m+1,n});
                        visited[m+1][n] = true;
                    }
                }
                if(n-1>=0) {
                    if(A[m][n-1] == 1 && !visited[m][n-1]) {
                        return level;
                    }else {
                        queue.offer(new int[]{m,n-1});
                        visited[m][n-1] = true;
                    }
                }
                if(n+1 < y) {
                    if(A[m][n+1] == 1 && !visited[m][n+1]) {
                        return level;
                    }else {
                        queue.offer(new int[]{m,n+1});
                        visited[m][n+1] = true;
                    }
                }
            }
              level++;
        }
        throw new IllegalStateException("不存在这个情况");
    }


    private void getFirstIsland(int[][] A) {
        Queue<int[]> startQueue = new LinkedList<>();
        for(int i=0;i<x;i++) {
            for(int j=0;j<y;j++) {
                if(A[i][j] ==1) {
                    queue.add(new int[]{i,j});
                    startQueue.add(new int[]{i,j});
                    visited[i][j] = true;
                    break;
                }
            }
            if(!queue.isEmpty()) {
                break;
            }
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0;i<size;i++) {
                int[] poll = queue.poll();
                int m = poll[0];
                int n = poll[1];
                if(m-1>=0) {
                    if(A[m-1][n] == 1 && !visited[m-1][n]) {
                        queue.add(new int[]{m-1,n});
                        startQueue.add(new int[]{m-1,n});
                        visited[m-1][n] = true;
                    }
                }
                if(m+1 < x) {
                    if(A[m+1][n] == 1 && !visited[m+1][n]) {
                        queue.add(new int[]{m+1,n});
                        startQueue.add(new int[]{m+1,n});
                        visited[m+1][n] = true;
                    }
                }
                if(n-1>=0) {
                    if(A[m][n-1] == 1 && !visited[m][n-1]) {
                        queue.add(new int[]{m,n-1});
                        startQueue.add(new int[]{m,n-1});
                        visited[m][n-1] = true;
                    }
                }
                if(n+1 < y) {
                    if(A[m][n+1] == 1 && !visited[m][n+1]) {
                        queue.add(new int[]{m,n+1});
                        startQueue.add(new int[]{m,n+1});
                        visited[m][n+1] = true;
                    }
                }
            }
        }
        queue = startQueue;
    }
}
