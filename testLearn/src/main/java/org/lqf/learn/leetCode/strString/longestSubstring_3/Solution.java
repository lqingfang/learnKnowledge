package org.lqf.learn.leetCode.strString.longestSubstring_3;


import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        String s = "dvdf";
        System.out.println(findLongestSubString(s));
    }

    private static int findLongestSubString(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int longestLength = 1;
        int begin = 0;
        Map<Character,Integer> map = new HashMap<>();
        for (int i=0;i<s.length();i++) {
            if(map.containsKey(s.charAt(i))) {
                begin = Math.max(begin,map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i),i);
            longestLength = Math.max(longestLength,i-begin+1);
        }

        return longestLength;
    }
}
