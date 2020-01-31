package org.lqf.learn.leetCode.backTrack.restoreIpAddresses_93;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        System.out.println(restoreIpAddresses("25525511135"));
    }
    static List<String> res;
    public static List<String> restoreIpAddresses(String s) {
        res = new ArrayList<>();
        dfs(s,0,new ArrayList<>());
        return res;
    }

    private static void dfs(String s, int position, List<String> cur) {
        if(cur.size() == 4) {
            if(position == s.length()) {
                res.add(String.join(".",cur));
            }
            return;
        }
        for(int i=1;i<=3;i++) {
            if(position+i > s.length()) {
                break;
            }
            String subStr = s.substring(position, position+i);
            if((subStr.startsWith("0") && subStr.length() >1)|| (Integer.valueOf(subStr) > 255)) {
                continue;
            }
            cur.add(subStr);
            dfs(s,position+i,cur);
            cur.remove(cur.size()-1);
        }
    }
}
