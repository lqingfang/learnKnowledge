package org.lqf.learn.leetCode.backTrack.removeInvalidParentheses_301;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 1、如何判断一个字符串是否是合法的括号
 *     int cnt = 0;
 *     (   cnt++;
 *     )   cnt--;
 *     cnt始终大于等于0，并且最终为0
 */
public class Solution {
    public static void main(String[] args) {
        String s= "3(()())(()";
        System.out.println(removeInvalidParentheses(s));
    }

    static Set<String> ans = new HashSet<>();
    public static List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        int leftDel = 0;
        int rightDel = 0;
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i) == '(') {
                leftDel++;
            }else if(s.charAt(i) == ')') {
                if(leftDel > 0){
                    leftDel--;
                }else {
                    rightDel++;
                }
            }
        }
        dfs(s,0,0,leftDel,rightDel,new StringBuilder());
        res.addAll(ans);
        return res;
    }
    private static void dfs(String s, int index, int leftCount, int leftDel, int rightDel, StringBuilder sb) {
        if(index == s.length()) {
            if(leftDel == 0 && rightDel == 0) {
                ans.add(sb.toString());
            }
            return;
        }
        char c = s.charAt(index);
        if( c == '(') {
            if(leftDel > 0) {
                dfs(s,index+1,leftCount,leftDel-1,rightDel,sb);
            }
            sb.append(c);
            dfs(s,index+1,leftCount+1,leftDel,rightDel,sb);
            sb.deleteCharAt(sb.length()-1);
        }else if(c == ')') {
            if(rightDel > 0) {
                dfs(s,index+1,leftCount,leftDel,rightDel-1,sb);
            }
            if(leftCount > 0) {
                sb.append(c);
                dfs(s,index+1,leftCount-1,leftDel,rightDel,sb);
                sb.deleteCharAt(sb.length()-1);
            }
        }else {
            sb.append(c);
            dfs(s,index+1,leftCount,leftDel,rightDel,sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
