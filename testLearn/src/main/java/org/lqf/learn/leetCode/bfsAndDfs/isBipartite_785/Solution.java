package org.lqf.learn.leetCode.bfsAndDfs.isBipartite_785;

import java.util.LinkedList;
import java.util.Queue;

/**
 * bfs
 */
public class Solution {
    public static void main(String[] args) {
        int[][] graph = new int[][]{
                {1,3}, {0,2}, {1,3}, {0,2}
        };
        System.out.println(isBipartite(graph));
    }
    public static boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];
        Queue<Integer> queue = new LinkedList<>();

        for(int i=0;i<graph.length;i++) {
            if(graph[i].length >0 && color[i] ==0){
                queue.offer(i);
                color[i] = 1;
                while (!queue.isEmpty()) {
                    Integer poll = queue.poll();
                    int setNum = color[poll] == 1?2:1;
                    for(int j=0;j<graph[poll].length;j++) {
                        if(color[graph[poll][j]] ==0) {
                            queue.offer(graph[poll][j]);
                            color[graph[poll][j]] = setNum;
                        }else if(color[graph[poll][j]] ==1 && setNum ==2){
                            return false;
                        }else if(color[graph[poll][j]] ==2 && setNum ==1){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
