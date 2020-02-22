package org.lqf.learn.leetCode.bfsAndDfs.pacificAtlantic_417;

import java.util.*;

public class Solution02 {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1,2,2,3,5},
                {3,2,3,4,4},
                {2,4,5,3,1},
                {6,7,1,4,5},
                {5,1,1,2,4}
        };
        System.out.println(pacificAtlantic(matrix));
    }
    static boolean[][] pacific;
    static boolean[][] atlantic;
    static int row;
    static int col;
    public static List<List<Integer>> pacificAtlantic(int[][] matrix) {
        if(null == matrix || matrix.length == 0){
            return Collections.emptyList();
        }
        row = matrix.length;
        col = matrix[0].length;
        pacific = new boolean[row][col];
        atlantic = new boolean[row][col];
        //第一行，最后一行
        for(int j=0;j<col;j++) {
            bfs(matrix,0,j,pacific);
            bfs(matrix,row-1,j,atlantic);
        }
        //第一列，最后一列
        for(int i=0;i<row;i++) {
            bfs(matrix,i,0,pacific);
            bfs(matrix,i,col-1,atlantic);
        }
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<row;i++) {
            for(int j=0;j<col;j++) {
                if(pacific[i][j] && atlantic[i][j]) {
                    res.add(Arrays.asList(i,j));
                }
            }
        }
        return res;
    }

    private static void bfs(int[][] matrix, int i, int j,boolean[][] visited) {
        if(visited[i][j]) {
            return;
        }
        LinkedList<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i,j});
        visited[i][j] = true;
        int curI,curJ;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            curI = poll[0];
            curJ = poll[1];
            if(curI+1 < row ){
                if(matrix[curI+1][curJ] >= matrix[curI][curJ] && !visited[curI+1][curJ]) {
                    queue.offer(new int[]{curI+1,curJ});
                    visited[curI+1][curJ] = true;
                }
            }
            if(curI-1 >= 0 ){
                if(matrix[curI-1][curJ] >= matrix[curI][curJ] && !visited[curI-1][curJ]) {
                    queue.offer(new int[]{curI-1,curJ});
                    visited[curI-1][curJ] = true;
                }
            }
            if(curJ+1 < col ){
                if(matrix[curI][curJ+1] >= matrix[curI][curJ] && !visited[curI][curJ+1]) {
                    queue.offer(new int[]{curI,curJ+1});
                    visited[curI][curJ+1] = true;
                }
            }
            if(curJ-1 >= 0 ){
                if(matrix[curI][curJ-1] >= matrix[curI][curJ] && !visited[curI][curJ-1]) {
                    queue.offer(new int[]{curI,curJ-1});
                    visited[curI][curJ-1] = true;
                }
            }
        }
    }
}
