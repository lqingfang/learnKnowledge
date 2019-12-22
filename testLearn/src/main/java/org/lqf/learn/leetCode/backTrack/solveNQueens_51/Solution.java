package org.lqf.learn.leetCode.backTrack.solveNQueens_51;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        System.out.println(solveNQueens(4));
    }

    static List<List<String>> res = new ArrayList<>();
    static List<String> ans = new ArrayList<>();
    public static List<List<String>> solveNQueens(int n) {
        StringBuilder sb = new StringBuilder();
        for(int i =0;i<n;i++) {
            sb.append(".");
        }
        queen(n,new boolean[n],new boolean[2*n-1],new boolean[2*n-1],sb,0);
        return res;
    }
    /**
     * i表示第几行
     * 只有集齐了n行，再加入结果集中
    */
    private static void queen(int n, boolean[] cols, boolean[] left, boolean[] right, StringBuilder sb, int i) {
        if(ans.size() == n) {
            res.add(new ArrayList<>(ans));
            return;
        }
        for(int j=0;j<n;j++) {
            if(cols[j] || left[n-1-i+j] || right[i+j]){
                continue;
            }
            cols[j] = true;
            left[n-1-i+j] = true;
            right[i+j] = true;
            ans.add(new StringBuilder(sb).replace(j,j+1,"Q").toString());
            queen(n,cols,left,right,sb,i+1);
            cols[j] = false;
            left[n-1-i+j] = false;
            right[i+j] = false;
            ans.remove(i);
        }
    }


}
