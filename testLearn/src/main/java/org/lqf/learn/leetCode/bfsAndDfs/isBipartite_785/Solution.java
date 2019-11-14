package org.lqf.learn.leetCode.bfsAndDfs.isBipartite_785;

public class Solution {
    public static void main(String[] args) {
        int[][] graph = new int[][]{
             {1,3}, {0,2}, {1,3}, {0,2}
        };
        System.out.println(isBipartite(graph));
    }
    public static boolean isBipartite(int[][] graph) {
        if(null == graph || graph.length == 0) {
            return false;
        }
        int[] colors = new int[graph.length];
        for(int i=0;i<graph.length;i++) {
            if(!dfs(graph,i,colors,0)) {
                return false;
            }
        }
        return true;
    }
    private static boolean dfs(int[][] graph, int i, int[] colors, int lastColor) {
        if(colors[i] != 0) {
            return colors[i] != lastColor;
        }
        colors[i] = lastColor ==1?2:1;
        for(int j=0;j<graph[i].length;j++) {
            if(!dfs(graph,graph[i][j],colors,colors[i])) {
                return false;
            }
        }
        return true;
    }
}
