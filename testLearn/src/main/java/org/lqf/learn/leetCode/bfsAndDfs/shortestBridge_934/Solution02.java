package org.lqf.learn.leetCode.bfsAndDfs.shortestBridge_934;

import java.util.LinkedList;
import java.util.Queue;

public class Solution02 {
    public static void main(String[] args) {
        Solution02 solution = new Solution02();
        int[][] A = new int[][]{{1,1,1,1,1}, {1,0,0,0,1}, {1,0,1,0,1},
                {1,0,0,0,1}, {1,1,1,1,1}};
        System.out.println(solution.shortestBridge(A));
    }
    boolean[][] visited;
    Queue<int[]> queue = new LinkedList<>();
    int x;
    int y;
    private static int[][] DIRECTIONS = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
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
                for (int[] direction : DIRECTIONS) {
                    int x = m + direction[0];
                    int y = n + direction[1];
                    if (!this.inArea(x, y)) {
                        continue;
                    }
                    if (visited[x][y]) { // 跳过已经访问
                        continue;
                    }
                    if (A[x][y] == 1) {
                        return level;
                    }
                    int[] xy = new int[]{x, y};
                    queue.add(xy);
                    visited[x][y] = true;
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
                for (int[] direction : DIRECTIONS) {
                    int x = m + direction[0];
                    int y = n + direction[1];
                    if (!this.inArea(x, y)) {
                        continue;
                    }
                    if (A[x][y] == 0) { // 跳过非岛屿
                        continue;
                    }
                    if (visited[x][y]) { // 跳过已经访问
                        continue;
                    }
                    int[] xy = new int[]{x, y};
                    queue.add(xy);
                    startQueue.add(xy);
                    visited[x][y] = true;
                }
            }
        }
        queue = startQueue;
    }
    private boolean inArea(int i, int j) {
        return i >= 0 && i < x
                && j >= 0 && j < y;
    }
}
