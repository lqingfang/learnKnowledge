package org.lqf.learn.leetCode.bfsAndDfs.findRedundantConnection_684;

public class UnionFind {
    //表示是谁的parent
    private int[] parent;
    //rank[i]表示有几个儿子
    private int[] rank;

    public UnionFind(int total) {
        parent = new int[total];
        rank = new int[total];
        for(int i =0;i<total;i++) {
            //初始的父节点都是自己
            parent[i] = i;
            //初始的儿子节点只有一个，即自己
            rank[i] = 1;
        }
    }
    public int findParent(int x){
        while (x != parent[x]) {
            //走了两步
            //分开理解啊：比如 1 -> 2 -> 3，现在要找1的parent节点
            //parent[x]则为  2，再parent[x]则为3
            //此时是把1的parent设到了3；
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }
    public void unionElement(int x,int y) {
        int xParent = findParent(x);
        int yParent = findParent(y);
        if(xParent == yParent) {
            return;
        }
        if(rank[xParent] > rank[yParent]) {
                parent[yParent] = xParent;
        }else if(rank[xParent] < rank[yParent]) {
                parent[xParent] = yParent;
        }else {
            parent[yParent] = xParent;
            rank[xParent] +=1;
        }

    }
}
