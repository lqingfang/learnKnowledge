package org.lqf.learn.leetCode.bfsAndDfs.numSquares_279;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution01 {
    public static void main(String[] args) {
        System.out.println(numSquares(8));
    }
    public static int numSquares(int n) {
        int max = (int)Math.sqrt(n);
        boolean[] visited = new boolean[n];
        List<Integer> list = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<=max;i++) {
            int squrt = i*i;
            if(n == squrt) {
                return 1;
            }
            list.add(squrt);
            queue.offer(squrt);
            visited[i] = true;
        }
        int count = 1;
        while (true) {
            count++;
            int size = queue.size();
            for(int i=0;i<size;i++) {
                int poll = queue.poll();
                for(int j=0;j<list.size();j++) {
                    int sum = poll+list.get(j);
                    if(n == sum) {
                        return count;
                    }
                    if(n < sum) {
                        break;
                    }
                    if(!visited[sum]) {
                        queue.offer(sum);
                        list.add(sum);
                        visited[sum] = true;
                    }
                }
            }
        }
    }
}
