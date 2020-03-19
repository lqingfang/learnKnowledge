package org.lqf.learn.leetCode.recycle.decodeString_394;

import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        System.out.println(decodeString("2[c2[ab]]"));
    }
    public static String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        Stack<Integer> times = new Stack<>();

        int currentNum = 0;
        String currentStr = "";
        for(int i=0;i<s.length();i++) {
            char temp = s.charAt(i);
            if(isNum(temp)) {
                currentNum = currentNum*10 + Integer.parseInt(temp+"");
            } else if(temp == '[') {
                stack.push(currentStr);
                times.push(currentNum);
                currentNum = 0;
                currentStr = "";
            } else if(temp == ']') {
                Integer time = times.pop();
                String str = stack.pop();
                while (time >0) {
                    str +=currentStr;
                    time--;
                }
                currentStr = str;
            } else {
                currentStr += temp;
            }
        }

        return currentStr;
    }

    private static boolean isNum(char temp) {
        return temp >='0' && temp <='9';
    }
}
