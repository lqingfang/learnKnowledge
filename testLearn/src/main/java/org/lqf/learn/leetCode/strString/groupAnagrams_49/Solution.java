package org.lqf.learn.leetCode.strString.groupAnagrams_49;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length == 0) {
            return Collections.emptyList();
        }
        Map<String,List<String>> ans = new HashMap<>();
        for(int i=0;i<strs.length;i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if(!ans.containsKey(key)) {
                ans.put(key,new ArrayList<>());
            }
            ans.get(key).add(strs[i]);
        }
        return new ArrayList<>(ans.values());
    }
}
