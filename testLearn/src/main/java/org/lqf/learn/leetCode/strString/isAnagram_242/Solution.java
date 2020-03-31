package org.lqf.learn.leetCode.strString.isAnagram_242;

public class Solution {
    public boolean isAnagram(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        if(sLen != tLen) {
            return false;
        }
        int[] counter = new int[26];
        for(int i=0;i<sLen;i++) {
            counter[s.charAt(i)-'a']++;
            counter[t.charAt(i)-'a']--;
        }

        for(int count : counter) {
            if(count != 0) {
                return false;
            }
        }
        return true;
    }
}
