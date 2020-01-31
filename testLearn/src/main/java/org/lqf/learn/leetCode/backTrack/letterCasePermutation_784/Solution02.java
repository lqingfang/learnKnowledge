package org.lqf.learn.leetCode.backTrack.letterCasePermutation_784;

import java.util.ArrayList;
import java.util.List;

public class Solution02 {
    public static void main(String[] args) {
        System.out.println(letterCasePermutation("1a2b"));
    }
    public static List<String> letterCasePermutation(String S) {
        List<String> res = new ArrayList<>();
        dfs(S,S.toCharArray(),0,res);
        return res;
    }

    private static void dfs(String s,char[] cur, int index, List<String> res) {
        res.add(String.valueOf(cur));
        for(int i=index;i<s.length();i++) {
            if(Character.isDigit(s.charAt(i))) {
                continue;
            }else {
                if(Character.isUpperCase(s.charAt(i))) {
                    cur[i] = Character.toLowerCase(s.charAt(i));
                }else {
                    cur[i] = Character.toUpperCase(s.charAt(i));
                }
                dfs(s,cur,i+1,res);
                if(Character.isUpperCase(s.charAt(i))) {
                    cur[i] = Character.toUpperCase(s.charAt(i));
                }else {
                    cur[i] = Character.toLowerCase(s.charAt(i));
                }
            }
        }
    }
}
