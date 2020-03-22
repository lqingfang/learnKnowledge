package org.lqf.learn.leetCode.binarySearch.timeMap_981;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TimeMap {
    public static void main(String[] args) {
        TimeMap timeMap = new TimeMap();
        timeMap.set("love","high",10);
        timeMap.set("love","low",20);
        System.out.println(timeMap.get("love",5));
        System.out.println(timeMap.get("love",10));
    }
    public TimeMap() {

    }
    Map<String, TreeMap<Integer,String>> map = new HashMap<>();

    public void set(String key, String value, int timestamp) {
        TreeMap<Integer,String> treeMap;
        if(null != map.get(key)) {
            treeMap = map.get(key);
            treeMap.put(timestamp,value);
        } else {
            treeMap = new TreeMap<>();
            treeMap.put(timestamp,value);
        }
        map.put(key,treeMap);
    }

    public String get(String key, int timestamp) {
        TreeMap<Integer, String> treeMap = map.get(key);
        while (timestamp >=0) {
            if(null != treeMap.get(timestamp)) {
                return treeMap.get(timestamp);
            }
            timestamp--;
        }
        return "";
    }
}
