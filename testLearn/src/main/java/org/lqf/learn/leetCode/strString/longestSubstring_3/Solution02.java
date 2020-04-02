package org.lqf.learn.leetCode.strString.longestSubstring_3;

import java.util.HashSet;
import java.util.Set;

public class Solution02 {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        int ans = 0,i=0,j=0;
        Set<Character> set = new HashSet<>();
        while (i<len && j<len) {
            if(!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                ans = Math.max(ans,j-i);
            }else {
                set.remove(s.charAt(i));
                i++;
            }
        }
        return ans;
    }
}
