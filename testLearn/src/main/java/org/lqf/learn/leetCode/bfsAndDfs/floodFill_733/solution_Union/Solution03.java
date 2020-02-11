package org.lqf.learn.leetCode.bfsAndDfs.floodFill_733.solution_Union;

import java.util.Arrays;

/**
 * 并查集
 */
public class Solution03 {
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
        int rowNum = image.length;
        int colNum = image[0].length;
        int oldColor = image[sr][sc];
        UnionFind unionFind = new UnionFind(rowNum*colNum);
        //
        for(int i=0;i<rowNum;i++) {
            for(int j=0;j<colNum;j++) {
                if(image[i][j] != oldColor) {
                    continue;
                }
                int right = j+1;
                int down = i+1;
                if(right<colNum && image[i][right] == oldColor) {
                    unionFind.union(i*colNum+j,i*colNum+right);
                }
                if(down<rowNum && image[down][j] == oldColor) {
                    unionFind.union(i*colNum+j,(down)*colNum+j);
                }
            }
        }
        for(int i=0;i<rowNum;i++) {
            for(int j=0;j<colNum;j++) {
                if(unionFind.connected(i*colNum+j,sr*colNum+sc)) {
                    image[i][j] = newColor;
                }
            }
        }
        return image;
    }
}
