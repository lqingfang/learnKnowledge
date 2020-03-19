package org.lqf.learn.leetCode.recycle.countOfAtoms_726;

import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

public class Solution02 {
    public static void main(String[] args) {
        System.out.println(countOfAtoms("K4(ON(SO3)2)2"));
    }
    public static String countOfAtoms(String formula) {
        int len = formula.length();
        if(len < 1) {
            return "";
        }
        Stack<Map<String,Integer>> stack = new Stack<>();
        stack.push(new TreeMap<>());

        char[] chars = formula.toCharArray();
        int i = 0;
        while (i<len) {
            if(chars[i] == '(') {
                stack.push(new TreeMap<>());
                i++;
            }else if(chars[i] == ')') {
                Map<String, Integer> top = stack.pop();
                int start = ++i,multiplicity;
                while (i<len && Character.isDigit(chars[i])) {
                    i++;
                }
                multiplicity = start<i?Integer.parseInt(formula.substring(start,i)):1;
                for(String c: top.keySet()) {
                    int v = top.get(c);
                    stack.peek().put(c,stack.peek().getOrDefault(c,0) + v* multiplicity);
                }
            }else {
                int start = i++;
                while (i<len && Character.isLowerCase(chars[i])) {
                    i++;
                }
                String key = formula.substring(start,i);

                start = i;
                while (i<len && Character.isDigit(chars[i])) {
                    i++;
                }
                int count = start<i?Integer.parseInt(formula.substring(start,i)):1;
                stack.peek().put(key,stack.peek().getOrDefault(key,0)+count);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for(String key:stack.peek().keySet()) {
            stringBuilder.append(key);
            int count = stack.peek().get(key);
            if(count>1) {
                stringBuilder.append(count);
            }
        }
        return stringBuilder.toString();
    }
}
