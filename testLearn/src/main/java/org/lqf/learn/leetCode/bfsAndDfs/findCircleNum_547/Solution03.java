package org.lqf.learn.leetCode.bfsAndDfs.findCircleNum_547;

import java.util.Arrays;

public class Solution03 {
    public static void main(String[] args) {

    }
    static int[] parent;
    public int findCircleNum(int[][] M) {
        int row = M.length;
        parent = new int[row];
        Arrays.fill(parent,-1);
        for(int i=0;i<row;i++) {
            for(int j=0;j<i;j++) {
                if(M[i][j] == 1 && i!=j) {
                    union(M,i,j);
                }
            }
        }
        int count = 0;
        for(int i=0;i<row;i++) {
            if(parent[i] == -1) {
                count++;
            }
        }
        return count;
    }

    private void union(int[][] m, int i, int j) {
        int parentI = findParent(i);
        int parentJ = findParent(j);
        if(parentI != parentJ) {
            parent[parentI] = parentJ;
        }
    }

    private int findParent(int i) {
        if(parent[i] == -1) {
            return i;
        }
        return findParent(parent[i]);
    }
}
