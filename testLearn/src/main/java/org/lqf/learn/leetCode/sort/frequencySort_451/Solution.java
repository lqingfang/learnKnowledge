package org.lqf.learn.leetCode.sort.frequencySort_451;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        System.out.println(frequencySort("tree"));
    }
    public static String frequencySort(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++) {
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        List<Map.Entry<Character,Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        for(Map.Entry<Character,Integer> entryMap : list) {
            for(int i=0;i<entryMap.getValue();i++) {
                stringBuilder.append(entryMap.getKey());
            }
        }
        return stringBuilder.toString();
    }
}
