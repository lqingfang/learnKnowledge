package org.lqf.learn.leetCode.bfsAndDfs.canVisitAllRooms_841;

import java.util.List;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {

    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] seen = new boolean[rooms.size()];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        while (!stack.isEmpty()) {
            Integer room = stack.pop();
            seen[room] = true;
            List<Integer> keyList = rooms.get(room);
            for(Integer key : keyList) {
                if(!seen[key]) {
                    stack.push(key);
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
