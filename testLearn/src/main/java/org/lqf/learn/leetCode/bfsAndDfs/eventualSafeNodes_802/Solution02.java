package org.lqf.learn.leetCode.bfsAndDfs.eventualSafeNodes_802;

import java.util.*;

/**
 * 深度遍历
 */
public class Solution02 {
    public static void main(String[] args) {
        int[][] array = new int[][]{
                {1, 2},
                {2, 3},
                {5},
                {0},
                {5},
                {},
                {}
        };
        List<Integer> list = eventualSafeNodes(array);
        System.out.println(list);
    }
    public static List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> res = new ArrayList<>();
        int[] color = new int[graph.length];
        for(int i=0;i<graph.length;i++) {
            if(graph[i].length == 0 || dfs(graph,i,color,res)){
                res.add(i);
            }
        }
        return res;
    }
    //0代表没有访问过，1代表本次访问过，2代表访问过，无环
    private static boolean dfs(int[][] graph, int i, int[] color, List<Integer> res) {
        if(color[i] >0) {
            return color[i] == 2;
        }
        color[i] = 1;
        int[] array = graph[i];
        for(int j=0;j<array.length;j++) {
            if(color[array[j]] == 2){
                continue;
            }
            if(color[array[j]]==1 || !dfs(graph,array[j],color,res)) {
                return false;
            }
        }
        color[i] = 2;
        return true;
    }
}
