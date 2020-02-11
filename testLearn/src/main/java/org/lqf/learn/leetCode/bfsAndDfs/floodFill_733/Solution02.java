package org.lqf.learn.leetCode.bfsAndDfs.floodFill_733;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * bfs
 */
public class Solution02 {
    public static void main(String[] args) {
        int[][] image = new int[][]{
                {1,1,1},{1,1,0},{1,0,1}
        };
        int sr = 1;
        int sc = 1;
        int newColor = 2;
        System.out.println(Arrays.deepToString(floodFill(image,sr,sc,newColor)));
    }
    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(null ==image || image.length==0 || image[sr].length ==0 || image[sr][sc] == newColor) {
            return image;
        }
        int oldColor = image[sr][sc];
        Queue<int[]> queue = new LinkedList<>();
        image[sr][sc] = newColor;
        queue.offer(new int[]{sr,sc});
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int i = poll[0];
            int j = poll[1];

            if(i+1<image.length && image[i+1][j]== oldColor) {
                image[i+1][j] = newColor;
                queue.offer(new int[]{i+1,j});
            }
            if(i-1>=0 && image[i-1][j]== oldColor) {
                image[i-1][j] = newColor;
                queue.offer(new int[]{i-1,j});
            }
            if(j+1<image[i].length && image[i][j+1]== oldColor) {
                image[i][j+1] = newColor;
                queue.offer(new int[]{i,j+1});
            }
            if(j-1>=0 && image[i][j-1]== oldColor) {
                image[i][j-1] = newColor;
                queue.offer(new int[]{i,j-1});
            }
        }
        return image;
    }
}
