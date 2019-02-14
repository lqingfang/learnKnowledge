package org.lqf.learn.collec;

import java.util.HashMap;
import java.util.Map;

public class HashMapTest {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<String, String>();
        map.put("1","a");
        map.put("2","b");
        map.put("3","c");
        map.put("3","d");
        map.put("3","w");
        map.put("2","p");
    }
}
