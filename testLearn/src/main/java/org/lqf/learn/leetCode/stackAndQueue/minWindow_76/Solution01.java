package org.lqf.learn.leetCode.stackAndQueue.minWindow_76;

import java.util.HashMap;
import java.util.Map;

public class Solution01 {
    public String minWindow(String s, String t) {
        int s_len = s.length();
        int t_len = t.length();

        if(s_len == 0 || t_len == 0) {
            return "";
        }
        if(s_len == t_len && s.equals(t)) {
            return s;
        }
        Map<Character,Integer> dicMap = new HashMap<>();
        for(int i=0;i<t_len;i++) {
            dicMap.put(t.charAt(i),dicMap.getOrDefault(t.charAt(i),0)+1);
        }
        int required = dicMap.size();
        int left = 0;
        int right = 0;
        int formed = 0;
        Map<Character,Integer> windowMap = new HashMap<>();
        //ans[0] 记录的是子窗口的最小长度
        int[] ans = {-1,0,0};
        while (right < s_len) {
            char c = s.charAt(right);
            windowMap.put(c,windowMap.getOrDefault(c,0)+1);
            if(dicMap.containsKey(c) && windowMap.get(c).intValue() == dicMap.get(c).intValue()) {
                formed++;
            }
            while (left <= right && formed == required) {
                c = s.charAt(left);
                if(ans[0] == -1 || right-left+1 < ans[0]) {
                    ans[0] = right-left+1;
                    ans[1] = left;
                    ans[2] = right;
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
