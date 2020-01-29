package org.lqf.learn.leetCode.greedy.isSubsequence_392;

public class Solution {
    public static void main(String[] args) {
        String s = "abc";
        String t = "ahbgdc";
        System.out.println(isSubsequence(s,t));
    }
    public static boolean isSubsequence(String s, String t) {
        if(s == null || s.length() == 0) {
            return true;
        }
        int index = 0;
        for(int i=0;i<t.length();i++) {
            if(t.charAt(i) == s.charAt(index)) {
                index++;
            }
            if(index == s.length()) {
                return true;
            }
        }
        return false;
    }
}
