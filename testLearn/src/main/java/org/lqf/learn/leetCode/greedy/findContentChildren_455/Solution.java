package org.lqf.learn.leetCode.greedy.findContentChildren_455;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] g = {7,8,9,10};
        int[] s = {5,6,7,8};
        System.out.println(findContentChildren(g,s));
    }
    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i=0;
        for(int j=0;i<g.length && j<s.length;j++) {
            if(g[i] <= s[j]) {
                i++;
            }
        }
        return i;
    }
}
