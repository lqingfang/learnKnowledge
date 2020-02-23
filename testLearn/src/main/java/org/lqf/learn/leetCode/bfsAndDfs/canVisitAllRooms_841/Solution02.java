package org.lqf.learn.leetCode.bfsAndDfs.canVisitAllRooms_841;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * bfs
 * bfs一把过，哈哈
 */
public class Solution02 {
    public static void main(String[] args) {

    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int size = rooms.size();
        boolean[] unLock = new boolean[size];
        Queue<List<Integer>> queue = new LinkedList<>();
        queue.add(rooms.get(0));
        unLock[0] = true;
        while (!queue.isEmpty()) {
            List<Integer> poll = queue.poll();
            for(Integer i:poll) {
                if(!unLock[i]) {
                    unLock[i] = true;
                    queue.add(rooms.get(i));
                }
            }
        }
        for(int i=0;i<size;i++) {
            if(!unLock[i]) {
                return false;
            }
        }
        return true;
    }
}
