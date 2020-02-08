package org.lqf.learn.leetCode.bfsAndDfs.eventualSafeNodes_802;

import java.util.*;

/**
 * 层次遍历
 */
public class Solution03 {
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
        Queue<Integer> queue = new LinkedList<>();
        //存出边
        List<Set<Integer>> G = new ArrayList<>();
        //存入边
        List<Set<Integer>> rG = new ArrayList<>();

        for(int i=0;i<graph.length;i++) {
            G.add(new HashSet<>());
            rG.add(new HashSet<>());
        }
        for(int i=0;i<graph.length;i++) {
            //把没有出边的点放入队列
            if(graph[i].length == 0) {
                queue.offer(i);
            }
            for(int j=0;j<graph[i].length;j++) {
                G.get(i).add(graph[i][j]);
                rG.get(graph[i][j]).add(i);
            }
        }
        boolean[] safe = new boolean[graph.length];
        while (!queue.isEmpty()) {
            Integer j = queue.poll();
            safe[j] = true;
            //rG.get(j)获取的是 进来的点
            //因为j是安全点，此时，可以从G 中消掉
            //如果最终G[i] 不是空，说明不是安全点。
            for(int i:rG.get(j)){
                G.get(i).remove(j);
                if(G.get(i).isEmpty()) {
                    queue.offer(i);
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
