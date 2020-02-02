package org.lqf.learn.leetCode.backTrack.splitIntoFibonacci_842;

import java.util.ArrayList;
import java.util.List;

public class Solution01 {
    public static void main(String[] args) {
        String S = "123456579";
        System.out.println(splitIntoFibonacci(S));
    }
    static List<Integer> res;
    public static List<Integer> splitIntoFibonacci(String S) {
        res = new ArrayList<>();
        dfs(S,0);
        return res;
    }

    private static boolean dfs(String s, int index) {
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
            if(isFibonacci(Integer.valueOf(segment),res)) {
                res.add(Integer.valueOf(segment));
                if(dfs(s,i+1)){
                    return true;
                }
                //回溯
                res.remove(res.size()-1);
            }
        }
        return false;
    }

    private static boolean isFibonacci(Integer third, List<Integer> res) {
        int len = res.size();
        //当长度大于2的时候，就可以判断第三个数是否是前两个之和，如果是，再放到list中
        if(len <2) {
            return true;
        }
        if(res.get(len-1)+res.get(len-2) == third) {
            return true;
        }
        return false;
    }

}
