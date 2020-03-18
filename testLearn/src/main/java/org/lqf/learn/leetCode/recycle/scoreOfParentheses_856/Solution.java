package org.lqf.learn.leetCode.recycle.scoreOfParentheses_856;

public class Solution {
    public static void main(String[] args) {
        System.out.println(scoreOfParentheses("(())"));
    }
    public static int scoreOfParentheses(String S) {
        return score(S,0,S.length()-1);
    }

    public static int score(String s, int left, int right) {
        if(right - left ==1) {
            return 1;
        }
        int b = 0;
        for(int i=left;i<right;i++) {
            if(s.charAt(i) == '(') {
                b++;
            }
            if(s.charAt(i) == ')') {
                b--;
            }
            if(b == 0) {
                return score(s,left,i)+score(s,i+1,right);
            }
        }
        return 2*score(s,left+1,right-1);
    }
}
