package org.lqf.learn.leetCode.bfsAndDfs.canVisitAllRooms_841;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Solution02 {
    public static void main(String[] args) {

    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] seen = new boolean[rooms.size()];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        while (!queue.isEmpty()) {
            Integer room = queue.poll();
            seen[room] = true;
            List<Integer> keyList = rooms.get(room);
            for(Integer key : keyList) {
                if(!seen[key]) {
                    queue.add(key);
                }
            }
        }
        for(boolean b :seen) {
            if(!b) {
                return false;
            }
        }
        return true;
    }
}
