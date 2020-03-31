package org.lqf.learn.leetCode.strString.isIsomorphic_205;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        System.out.println(isIsomorphic("ab","aa"));
    }
    public static boolean isIsomorphic(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        if(sLen != tLen) {
            return false;
        }
        Map<Character,Character> map = new HashMap<>();
        for(int i=0;i<sLen;i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);
            if(null == map.get(charS)) {
                if(map.containsValue(charT)) {
                    return false;
                }
                map.put(charS,charT);
            }else if(map.get(charS) != charT) {
                return false;
            }
        }
        return true;
    }
}
