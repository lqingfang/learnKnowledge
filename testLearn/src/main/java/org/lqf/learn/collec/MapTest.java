package org.lqf.learn.collec;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class MapTest {
    public static void main(String[] args) {
        Map<String,String> testMap = new HashMap<String, String>();
        testMap.put("1","a");
        testMap.put("2","b");
        testMap.put("3","c");
        for (Map.Entry<String,String> map :testMap.entrySet()){
            String key = map.getKey();
            String value = map.getValue();
            System.out.println(key+"---"+value);
        }

    }
}
