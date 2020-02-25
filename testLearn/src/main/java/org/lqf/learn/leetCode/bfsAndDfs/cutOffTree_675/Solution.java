package org.lqf.learn.leetCode.bfsAndDfs.cutOffTree_675;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        List<List<Integer>> forest = new ArrayList<>();
        List list01 = Arrays.asList(1,2,3);
        List list02 = Arrays.asList(0,0,4);
        List list03 = Arrays.asList(7,6,5);
        forest.add(list01);
        forest.add(list02);
        forest.add(list03);
        System.out.println(cutOffTree(forest));
    }
    public static int cutOffTree(List<List<Integer>> forest) {
        List<int[]> trees = new ArrayList<>();
        for(int i=0;i<forest.size();i++) {
            for(int j=0;j<forest.get(i).size();j++) {
                int v = forest.get(i).get(j);
                if(v >1) {
                    trees.add(new int[]{forest.get(i).get(j),i,j});
                }
            }
        }
        Collections.sort(trees,(a,b)->
            Integer.compare(a[0],b[0])
        );
        int ans =0,startX = 0,startY = 0;
        for(int[] tree:trees) {
            //计算从startX,startY，到各棵树的距离
            int d = bfs(forest,startX,startY,tree[1],tree[2]);
            if(d<0) {
                return -1;
            }
            ans +=d;
            startX = tree[1];
            startY = tree[2];
        }
        return ans;
    }

    public static int bfs(List<List<Integer>> forest, int startX, int startY, int i, int j) {
        int row = forest.size();
        int col = forest.get(0).size();
        boolean[][] visited = new boolean[row][col];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX,startY,0});
        visited[startX][startY] = true;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if(cur[0] == i && cur[1] == j) {
                return cur[2];
            }
            if(cur[0]+1 < row && !visited[cur[0]+1][cur[1]] && forest.get(cur[0]+1).get(cur[1])>0) {
                visited[cur[0]+1][cur[1]] = true;
                queue.add(new int[]{cur[0]+1,cur[1],cur[2]+1});
            }
            if(cur[0]-1>=0 && !visited[cur[0]-1][cur[1]] && forest.get(cur[0]-1).get(cur[1])>0) {
                visited[cur[0]-1][cur[1]] = true;
                queue.add(new int[]{cur[0]-1,cur[1],cur[2]+1});
            }
            if(cur[1]+1 < col && !visited[cur[0]][cur[1]+1] && forest.get(cur[0]).get(cur[1]+1)>0) {
                visited[cur[0]][cur[1]+1] = true;
                queue.add(new int[]{cur[0],cur[1]+1,cur[2]+1});
            }
            if(cur[1]-1 >= 0 && !visited[cur[0]][cur[1]-1] && forest.get(cur[0]).get(cur[1]-1)>0) {
                visited[cur[0]][cur[1]-1] = true;
                queue.add(new int[]{cur[0],cur[1]-1,cur[2]+1});
            }
        }
        return -1;
    }
}
