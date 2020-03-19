package org.lqf.learn.leetCode.recycle.countOfAtoms_726;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

/**
 * 递归，注意使用了 treeMap 自动排序
 */
public class Solution01 {
    public static void main(String[] args) {
        System.out.println(countOfAtoms("K4(ON(SO3)2)2"));
    }

    public static String countOfAtoms(String formula) {
        StringBuilder stringBuilder = new StringBuilder();
        Map<String,Integer> map = parse(formula);
        for(String key:map.keySet()) {
            stringBuilder.append(key);
            Integer count = map.get(key);
            if(count > 1) {
                stringBuilder.append(count);
            }
        }
        return stringBuilder.toString();
    }

    static int i=0;
    private static Map<String, Integer> parse(String formula) {
        Map<String,Integer> countMap = new TreeMap<>();
        int len = formula.length();
        if(len <1) {
            return Collections.emptyMap();
        }
        char[] cf = formula.toCharArray();
        while (i<len && cf[i] != ')') {
            if(cf[i] == '(') {
                i++;
                Map<String, Integer> parseMap = parse(formula);
                for(String key:parseMap.keySet()) {
                    countMap.put(key,countMap.getOrDefault(key,0)+parseMap.get(key));
                }
            }else {
                int start = i++;
                while (i<len && Character.isLowerCase(cf[i])) {
                    i++;
                }
                String key = formula.substring(start,i);

                start = i;
                while (i<len && Character.isDigit(cf[i])) {
                    i++;
                }
                int count = start<i?Integer.parseInt(formula.substring(start,i)) : 1;

                countMap.put(key,countMap.getOrDefault(key,0)+count);
            }
        }
        int start = ++i;
        while (i<len && Character.isDigit(cf[i])) {
            i++;
        }
        if(start<i) {
            int count = Integer.parseInt(formula.substring(start,i));
            for(String key:countMap.keySet()) {
                countMap.put(key,countMap.get(key) * count);
            }
        }
        return countMap;
    }


}
