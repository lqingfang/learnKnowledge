package org.lqf.learn.leetCode.bfsAndDfs.canVisitAllRooms_841;

import java.util.List;

/**
 * dfs
 */
public class Solution01 {
    public static void main(String[] args) {

    }
    boolean[] unLock;
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int size = rooms.size();
        unLock = new boolean[size];
        dfs(rooms,0,unLock);
        for(int i=0;i<size;i++) {
            if(!unLock[i]) {
                return false;
            }
        }
        return true;
    }

    private void dfs(List<List<Integer>> rooms, int index, boolean[] unLock) {
        List<Integer> list = rooms.get(index);
        unLock[index] = true;
        for(int i:list) {
            if(!unLock[i]) {
                dfs(rooms,i,unLock);
            }
        }
    }
}
