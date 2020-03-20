package org.lqf.learn.leetCode.stackAndQueue.isValid_20;

import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        if(s.length()%2 == 1) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for(int i=0;i<chars.length;i++) {
            if(chars[i] == '(' || chars[i] == '{' || chars[i]=='[') {
                stack.add(chars[i]);
            }else {
                if(stack.isEmpty()) {
                    return false;
                }
                char c = stack.pop();
                if(chars[i] == ')' && c != '(') {
                    return false;
                }
                if(chars[i] == ']' && c != '[') {
                    return false;
                }
                if(chars[i] == '}' && c != '{') {
                    return false;
                }
            }
        }
        if(stack.size() >0) {
            return false;
        }
        return true;
    }
}
