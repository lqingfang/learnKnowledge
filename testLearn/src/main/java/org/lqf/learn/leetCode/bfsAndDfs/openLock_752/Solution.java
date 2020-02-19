package org.lqf.learn.leetCode.bfsAndDfs.openLock_752;

import java.util.*;

public class Solution {
    public static void main(String[] args) {

    }
    public int openLock(String[] deadends, String target) {
        Set<String> deadendSet = new HashSet<>();
        deadendSet.addAll(Arrays.asList(deadends));
        String start = "0000";
        if(deadendSet.contains(target) || deadendSet.contains(start)) {
            return -1;
        }
        Set<String> visited = new HashSet<>();

        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        visited.add(start);
        int step = 0;
        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            for(int k=0;k<size;k++) {
                String cur = queue.poll();
                for(int i=0;i<4;i++) {
                    for(int j=-1;j<=1;j+=2) {
                        String next = cur;
                        int y = ((next.charAt(i) - '0') + j + 10) % 10;
                        next = next.substring(0, i) + ("" + y) + next.substring(i+1);
                        if(next.equals(target)) {
                            return step;
                        }
                        if(deadendSet.contains(next)) {
                            continue;
                        }
                        if(!visited.contains(next)) {
                            visited.add(next);
                            queue.add(next);
                        }
                    }
                }
            }
        }
        return -1;
    }
}
