package org.lqf.learn.leetCode.bfsAndDfs.findRedundantConnection_684;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 拓扑排序
 */
public class Solution {
    public static void main(String[] args) {
        int[][] edge = new int[][]{{1,2},{2,3},{3,4},{1,4}, {1,5}};
        System.out.println(Arrays.toString(findRedundantConnection(edge)));
    }
    public static int[] findRedundantConnection(int[][] edges) {
        //inDegrees[i]表示有多少个节点 入 进来
        int[] degrees = new int[edges.length];
        for(int i=0;i<edges.length;i++) {
            degrees[edges[i][0]-1]++;
            degrees[edges[i][1]-1]++;
        }
        while (true) {
            int flag = -1;
            for(int i=0;i<edges.length;i++) {
                if(degrees[i] ==1) {
                    flag = 1;
                    for(int[] edge:edges) {
                        if(edge[0] == i+1 || edge[1] == i+1) {
                            degrees[edge[0]-1]--;
                            degrees[edge[1]-1]--;
                        }
                    }
                }
            }
            if(flag == -1) {
                break;
            }
        }
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<edges.length;i++) {
            if(degrees[i] == 2){
                list.add(i+1);
            }
        }
        for(int i=edges.length-1;i>=0;i--) {
            if(list.contains(edges[i][0]) && list.contains(edges[i][1])) {
                return edges[i];
            }
        }
        return new int[2];
    }
}
