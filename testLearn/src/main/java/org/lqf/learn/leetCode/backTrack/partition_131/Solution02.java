package org.lqf.learn.leetCode.backTrack.partition_131;

import java.util.ArrayList;
import java.util.List;

public class Solution02 {
    public static void main(String[] args) {
        String s = "abb";
        System.out.println(partition(s));
    }

    public static List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        dfs(s,0,new ArrayList<>(),res);
        return res;
    }

    private static void dfs(String s, int index, ArrayList<String> list, List<List<String>> res) {
        if(index == s.length()) {
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i=index;i<s.length();i++) {
            if(checkPartition(s,index,i)){
                list.add(s.substring(index,i+1));
                dfs(s,i+1,list,res);
                list.remove(list.size()-1);
            }
        }
    }

    private static boolean checkPartition(String s, int left, int right) {
        while (left < right) {
            if(s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }


}
