package org.lqf.learn.quartzLearn;

import java.util.HashMap;
import java.util.Map;

public class Example01Start {
    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", "1");
        Exemple01Schedule.addJob(ExempleJob01.class,"exempleJob01",1,map);
    }
}
