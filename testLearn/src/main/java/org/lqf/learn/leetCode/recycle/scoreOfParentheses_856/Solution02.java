package org.lqf.learn.leetCode.recycle.scoreOfParentheses_856;

import java.util.Stack;

public class Solution02 {
    public static void main(String[] args) {
        System.out.println(scoreOfParentheses("(()())"));
    }
    public static int scoreOfParentheses(String S) {
        if (S.length() == 0 || S == null) {
            return 0;
        }
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        for (char c : S.toCharArray()){
            if (c == '('){
                stack.push(res);
                res = 0; //当前分数清空
            }
            else{
                res = stack.peek()+Math.max(res*2,1);
                stack.pop();
            }
        }
        return res;
    }
}
