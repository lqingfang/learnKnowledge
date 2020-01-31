package org.lqf.learn.leetCode.backTrack.generateParenthesis_22;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 回溯，利用dfs，深度优先遍历
 */
public class Solution {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(generateParenthesis(n));
    }
    public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        if(n ==0) {
            return Collections.emptyList();
        }
        dfs(list,n,n,"");
        return list;
    }

    private static void dfs(List<String> list, int left, int right, String s) {
        if(left == 0 && right== 0) {
            list.add(s);
            return;
        }
        if(left>0) {
            dfs(list,left-1,right,s+"(");
        }
        if(right>0 && right>left) {
            dfs(list,left,right-1,s+")");
        }
    }
}
