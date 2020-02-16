package org.lqf.learn.leetCode.bfsAndDfs.minMutation_433;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        String start = "AACCGGTT";
        String end = "AAACGGTA";
        String[] bank = {"AACCGGTA", "AACCGCTA", "AAACGGTA"};
        System.out.println(minMutation(start,end,bank));
    }
    public static int minMutation(String start, String end, String[] bank) {
        int l = start.length();
        int level = 0;
        Set<String> set = new HashSet<String>();
        set.addAll(Arrays.asList(bank));
        if(!set.contains(end)) {
            return -1;
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        set.remove(start);
        char[] four = {'A','C','G','T'};
        while (!queue.isEmpty()) {
            level++;
            for(int count = queue.size(); count > 0; --count) {
                char[] cur = queue.poll().toCharArray();
                for(int i=0;i<l;i++) {
                    char oldChar = cur[i];
                    for(int j=0;j<four.length;j++) {
                        cur[i] = four[j];
                        String newGene = new String(cur);
                        if(newGene.equals(end)) {
                            return level;
                        }else if(set.contains(newGene)) {
                            set.remove(newGene);
                            queue.offer(newGene);
                        }
                    }
                    cur[i] = oldChar;
                }
            }
        }
        return -1;
    }
}
