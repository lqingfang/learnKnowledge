package org.lqf.learn.leetCode.dynamicPro.openLock_752;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        String[] deadends = {"0201","0101","0102","1212","2002"};
        String target = "0202";
        System.out.println(openLock(deadends,target));
    }
    public static int openLock(String[] deadends, String target) {
        if(null == target || target.length() ==0 ){
            return -1;
        }
        Set<String> deads = new HashSet<>(Arrays.asList(deadends));
        String start = "0000";
        if(deads.contains(target) || deads.contains(start)) {
            return -1;
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        Set<String> visited = new HashSet<>();
        visited.add(start);
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0;i<size;i++) {
                String curWord = queue.poll();
                if(curWord.equals(target)) {
                    return step;
                }
                List<String> nexts = getNexts(curWord);
                for (String nextWord : nexts) {
                    if(!deads.contains(nextWord) && visited.add(nextWord)) {
                        queue.offer(nextWord);
                    }
                }
            }
            step++;
        }
        return -1;
    }
    private static List<String> getNexts(String cur){
        List<String> list = new ArrayList<>();
        for(int i=0;i<4;i++) {
            char curChar = cur.charAt(i);
            StringBuilder stringBuilder = new StringBuilder(cur);
            stringBuilder.setCharAt(i,curChar == '0'?'9':(char)(curChar-1));
            list.add(stringBuilder.toString());
            stringBuilder.setCharAt(i,curChar == '9'?'0':(char) (curChar+1));
            list.add(stringBuilder.toString());
        }
        return list;
    }
}
