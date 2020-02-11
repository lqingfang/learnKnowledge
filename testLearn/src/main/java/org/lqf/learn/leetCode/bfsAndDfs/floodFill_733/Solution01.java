package org.lqf.learn.leetCode.bfsAndDfs.floodFill_733;

import java.util.Arrays;

/**
 * dfs
 */
public class Solution01 {
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
        dfs(image,sr,sc,newColor,image[sr][sc]);
        return image;
    }

    private static void dfs(int[][] image, int sr, int sc, int newColor,int oldColor) {
        if(sr<0 || sc <0 || sr>image.length || sc>image[sr].length || image[sr].length == 0 || image[sr][sc] == newColor) {
            return;
        }

        image[sr][sc] = newColor;
        if(sr+1<image.length && image[sr+1][sc] == oldColor){
            dfs(image,sr+1,sc,newColor,oldColor);
        }
        if(sr-1>=0  && image[sr-1][sc] == oldColor){
            dfs(image,sr-1,sc,newColor,oldColor);
        }
        if(sc+1<image[sr].length  && image[sr][sc+1] == oldColor){
            dfs(image,sr,sc+1,newColor,oldColor);
        }
        if(sc-1>=0  && image[sr][sc-1] == oldColor){
            dfs(image,sr,sc-1,newColor,oldColor);
        }

    }
}
