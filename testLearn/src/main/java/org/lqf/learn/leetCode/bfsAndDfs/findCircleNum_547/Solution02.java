package org.lqf.learn.leetCode.bfsAndDfs.findCircleNum_547;

import java.util.LinkedList;
import java.util.Queue;

public class Solution02 {
    public static void main(String[] args) {
//        int[][] M = new int[][]{
//                {1,0,0,1},
//                {0,1,1,0},
//                {0,1,1,1},
//                {1,0,1,1}
//        };
        int[][] M = new int[][]{
                {1,1,0},
                {1,1,0},
                {0,0,1}
        };
//        int[][] M = new int[][]{
//                {1,0,0},
//                {0,1,0},
//                {0,0,1}
//        };
        System.out.println(findCircleNum(M));
    }
    public static int findCircleNum(int[][] M) {
        int res = 0;
        int row = M.length;
        int col = M[0].length;
        boolean[] visited = new boolean[row];
        Queue<Integer> queue = new LinkedList<>();
        //对角线对称
        for(int i=0;i<row;i++) {
            if(!visited[i]) {
                queue.add(i);
                while (!queue.isEmpty()) {
                    Integer s = queue.remove();
                    if(!visited[s]) {
                        visited[s] = true;
                        for(int j=0;j<col;j++) {
                            if(M[s][j] == 1 && !visited[j]) {
                                queue.add(j);
                            }
                        }
                    }
                }
                res++;
            }
        }
        return res;
    }

}
