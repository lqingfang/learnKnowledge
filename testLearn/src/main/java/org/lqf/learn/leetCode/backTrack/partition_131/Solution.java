package org.lqf.learn.leetCode.backTrack.partition_131;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        String s = "abb";
        System.out.println(partition(s));
    }
    static List<List<String>> res = new ArrayList<>();
    public static List<List<String>> partition(String s) {
        backTracking(s,0,new Stack<String>());
        return res;
    }

    private static void backTracking(String s, int start, Stack<String> stack) {
        if(start == s.length()) {
            res.add(new ArrayList<>(stack));
            return;
        }
        for(int i=start;i<s.length();i++) {
            if(checkPalindrome(s,start,i)){
                stack.add(s.substring(start,i+1));
                backTracking(s,i+1,stack);
                stack.pop();
            }
        }
    }
    private static boolean checkPalindrome(String s,int left,int right){
        while (left<right) {
            if(s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}
