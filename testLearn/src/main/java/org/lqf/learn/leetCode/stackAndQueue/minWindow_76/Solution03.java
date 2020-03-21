package org.lqf.learn.leetCode.stackAndQueue.minWindow_76;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution03 {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s,t));
    }
    public static String minWindow(String s, String t) {
        int s_len = s.length();
        int t_len = t.length();

        if(s_len == 0 || t_len == 0) {
            return "";
        }
        Map<Character,Integer> dicMap = new HashMap<>();
        for(int i=0;i<t_len;i++) {
            dicMap.put(t.charAt(i),dicMap.getOrDefault(t.charAt(i),0)+1);
        }
        List<Pair<Integer,Character>> filterMap = new ArrayList<>();
        for(int i=0;i<s_len;i++) {
            if(dicMap.containsKey(s.charAt(i))) {
                filterMap.add(new Pair<>(i,s.charAt(i)));
            }
        }
        int required = dicMap.size();
        int left = 0;
        int right = 0;
        int formed = 0;
        Map<Character,Integer> windowMap = new HashMap<>();
        //ans[0] 记录的是子窗口的最小长度
        int[] ans = {-1,0,0};
        while (right < filterMap.size()) {
            char c = filterMap.get(right).getValue();
            windowMap.put(c,windowMap.getOrDefault(c,0)+1);
            if(dicMap.containsKey(c) && windowMap.get(c).intValue() == dicMap.get(c).intValue()) {
                formed++;
            }
            while (left <= right && formed == required) {
                c = filterMap.get(left).getValue();

                int end = filterMap.get(right).getKey();
                int start = filterMap.get(left).getKey();
                if(ans[0] == -1 || end-start+1 < ans[0]) {
                    ans[0] = end-start+1;
                    ans[1] = start;
                    ans[2] = end;
                }

                windowMap.put(c,windowMap.get(c)-1);
                if(dicMap.containsKey(c) && windowMap.get(c).intValue() < dicMap.get(c).intValue()) {
                    formed--;
                }
                left++;
            }
            right++;
        }

        return ans[0]==-1?"":s.substring(ans[1],ans[2]+1);
    }
}
