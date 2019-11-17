package org.lqf.learn.leetCode.dynamicPro.numSquares_279;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.numSquares(12));
//        System.out.println(solution.numSquares(13));
        System.out.println(solution.numSquares(14));
    }

    public int numSquares(int n) {
        if(n==0) {
            return 0;
        }
        List<Integer> list = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        int max = (int)Math.sqrt(n);
        for(int i=1;i<=max;i++) {
            int square = i*i;
            if(square == n) {
                return 1;
            }
            list.add(square);
            queue.add(square);
            visited[i] = true;
        }
        int count = 1;
        while (true) {
            count++;
            int size = queue.size();
            for(int i=0;i<size;i++) {
                int item = queue.poll();
                for(Integer number:list) {
                    int sum = item + number;
                    if(sum == n) {
                        return count;
                    }
                    if(sum > n) {
                        break;
                    }
                    if(!visited[sum]) {
                        queue.add(sum);
                        visited[sum] = true;
                    }
                }
            }
        }
    }
}
