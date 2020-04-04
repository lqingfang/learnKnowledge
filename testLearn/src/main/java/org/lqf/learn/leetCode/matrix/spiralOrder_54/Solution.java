package org.lqf.learn.leetCode.matrix.spiralOrder_54;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };
        System.out.println(spiralOrder(matrix));
    }
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int row = matrix.length;
        if(row == 0) {
            return res;
        }
        int col = matrix[0].length;
        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};
        int d = 0;
        int x=0,y=0;
        boolean[][] visited = new boolean[row][col];
        while (res.size() < row * col) {
            res.add(matrix[x][y]);
            visited[x][y] = true;
            int nx = x+dx[d];
            int ny = y+dy[d];
            if(nx>=0 && nx <row && ny>=0 && ny <col && !visited[nx][ny]) {
                x = nx;
                y = ny;
            }else {
                d = (d+1)%4;
                nx = x+dx[d];
                ny = y+dy[d];
                x = nx;
                y = ny;
            }
        }
        return res;
    }
}
