package org.lqf.learn.leetCode.greedy.partitionLabels_763;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        String S = "ababcbacadefegdehijhklij";
        System.out.println(partitionLabels(S));
    }
    public static List<Integer> partitionLabels(String S) {
        int[] last = new int[26];
        for(int i=0;i<S.length();i++) {
            last[S.charAt(i)-'a'] = i;
        }
        List<Integer> res = new ArrayList<>();
        int preIndex = -1;
        int maxIndex = 0;
        for(int i=0;i<S.length();i++) {
            int index = last[S.charAt(i) - 'a'];
            //扩大区间
            if(index > maxIndex) {
                maxIndex = index;
            }
            if(i == maxIndex){
                res.add(maxIndex-preIndex);
                preIndex = maxIndex;
            }
        }
        return res;
    }
}
