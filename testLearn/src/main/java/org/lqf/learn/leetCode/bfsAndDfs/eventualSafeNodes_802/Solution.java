package org.lqf.learn.leetCode.bfsAndDfs.eventualSafeNodes_802;

import java.util.*;

public class Solution {
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
        List<Set<Integer>> G = new ArrayList<>();
        List<Set<Integer>> rG = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        for(int i=0;i<graph.length;i++) {
            G.add(new HashSet<>());
            rG.add(new HashSet<>());
        }

        for(int i=0;i<graph.length;i++) {
            if(graph[i].length == 0) {
                queue.offer(i);
            }
            for(int j:graph[i]) {
                G.get(i).add(j);
                rG.get(j).add(i);
            }
        }
        boolean[] safe = new boolean[graph.length];
        while (!queue.isEmpty()) {
            int m = queue.poll();
            safe[m] = true;
            for(int k:rG.get(m)) {
                G.get(k).remove(m);
                if(G.get(k).isEmpty()) {
                    queue.offer(k);
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<graph.length;i++) {
            if(safe[i]) {
                res.add(i);
            }
        }
        return res;
    }
}
