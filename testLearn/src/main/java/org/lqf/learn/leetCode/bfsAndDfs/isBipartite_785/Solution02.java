package org.lqf.learn.leetCode.bfsAndDfs.isBipartite_785;

/**
 * dfs
 */
public class Solution02 {
    public static void main(String[] args) {
        int[][] graph = new int[][]{
             {1,3}, {0,2}, {1,3}, {0,2}
        };
        System.out.println(isBipartite(graph));
    }
    public static boolean isBipartite(int[][] graph) {
        //0:没有染色  1：红色   2：蓝色
        int[] color = new int[graph.length];
        for(int i=0;i<graph.length;i++) {
            if(!dfs(graph,i,color,0)) {
                return false;
            }
        }
        return true;
    }

    private static boolean dfs(int[][] graph, int index, int[] color,int lastColor) {
        if(color[index] != 0) {
            return color[index] != lastColor;
        }
        color[index] = lastColor == 1?2:1;
        for(int j=0;j<graph[index].length;j++) {
            if(!dfs(graph,graph[index][j],color,color[index])){
                return false;
            }
        }
        return true;
    }
}
