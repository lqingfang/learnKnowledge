package org.lqf.learn.leetCode.strString.strStr_28;

public class Solution {
    public int strStr(String haystack, String needle) {
        int lh = haystack.length();
        int ln = needle.length();
        if(lh < ln) {
            return -1;
        }
        int len = lh - lh;
        for(int i=0;i<=len;i++) {
            if(haystack.substring(i,i+ln).equals(needle)) {
                return i;
            }
        }
        return -1;
    }
}
