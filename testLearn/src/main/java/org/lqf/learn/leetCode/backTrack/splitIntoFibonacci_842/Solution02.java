package org.lqf.learn.leetCode.backTrack.splitIntoFibonacci_842;

import java.util.ArrayList;
import java.util.List;

public class Solution02 {
    public static void main(String[] args) {
        String S = "123456579";
        System.out.println(splitIntoFibonacci(S));
    }
    static List<Integer> res;
    public static List<Integer> splitIntoFibonacci(String S) {
        res = new ArrayList<>();
        dfs(S,0,0,0);
        return res;
    }

    private static boolean dfs(String s, int index,int first,int second) {
        if(index == s.length() && res.size() >2) {
            return true;
        }
        for(int i=index;i<s.length();i++) {
            String segment = s.substring(index,i+1);
            if(Long.parseLong(segment) > Integer.MAX_VALUE) {
                break;
            }
            if(!"0".equals(segment) && segment.startsWith("0")) {
                break;
            }
            //如果前两个数是第三个数之和，再放入list中
            int cur = Integer.valueOf(segment);
            if(res.size()<2 || first+second == cur) {
                res.add(cur);
                if(dfs(s,i+1,second,cur)){
                    return true;
                }
                //回溯
                res.remove(res.size()-1);
            }
        }
        return false;
    }

}
