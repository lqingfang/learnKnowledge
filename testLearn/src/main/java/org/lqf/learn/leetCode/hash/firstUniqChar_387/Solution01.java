package org.lqf.learn.leetCode.hash.firstUniqChar_387;

import java.util.HashMap;
import java.util.Map;

public class Solution01 {
    public static void main(String[] args) {
        String s = "cc";
        System.out.println(firstUniqChar(s));
    }
    public static int firstUniqChar(String s) {
        if(null == s || s.length() == 0) {
            return -1;
        }
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++) {
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        for(int i=0;i<s.length();i++) {
            if(map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}
