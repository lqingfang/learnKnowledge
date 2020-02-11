package org.lqf.learn.leetCode.bfsAndDfs.floodFill_733.solution_Union;

public class UnionFind {
    private int[] parent;

    public UnionFind(int num) {
        parent = new int[num];
        for(int i=0;i<num;i++) {
            parent[i] = i;
        }
    }
    public int find(int x) {
        while (x!= parent[x]) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }
    public void union(int x,int y) {
        int parentX = find(x);
        int parentY = find(y);
        if(parentX == parentY) {
            return;
        }
        parent[parentY] = parentX;
    }
    public boolean connected(int x,int y) {
        return find(x)==find(y);
    }
}
