package org.lqf.learn.leetCode.bfsAndDfs.findRedundantConnection_684;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[][] edges = new int[][]{
                {1,2},
                {1,3},
                {2,3}
        };
        System.out.println(Arrays.toString(findRedundantConnection(edges)));
    }
    public static int[] findRedundantConnection(int[][] edges) {
        int[] res = new int[2];
        UnionFind unionFind = new UnionFind(edges.length);
        // 第一条边肯定未记录至树中，可直接合并节点
        unionFind.unionElement(edges[0][0]-1,edges[0][1]-1);
        for(int i=1;i<edges.length;i++) {
            if(unionFind.findParent(edges[i][0]-1) == unionFind.findParent(edges[i][1]-1)) {
                res[0] = edges[i][0];
                res[1] = edges[i][1];
            }else {
                unionFind.unionElement(edges[i][0]-1,edges[i][1]-1);
            }
        }
        return res;
    }
}
