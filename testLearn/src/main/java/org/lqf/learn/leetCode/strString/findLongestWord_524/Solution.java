package org.lqf.learn.leetCode.strString.findLongestWord_524;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        List<String> d = new ArrayList<String>();
        d.add("ale");
        d.add("apple");
        d.add("monkey");
        d.add("plea");
        String s = "abpcplea";
        String resultWorld = findLongestWord(s,d);
        System.out.println(resultWorld);
    }

    private static String findLongestWord(String s, List<String> d) {
        d.sort((o1, o2) -> {
            int l1 = o1.length();
            int l2 = o2.length();
            if(l1 == l2) {
                return o1.compareTo(o2);
            }
            return l2-l1;
        });
        for(String minStr:d) {
            if(match(minStr,s)) {
                return minStr;
            }
        }
        return "";
    }

    private static boolean match(String minStr, String target) {
        char[] chars = minStr.toCharArray();
        int index = 0;
        for(char c:chars) {
            int foundIndex = target.indexOf(c,index);
            if(foundIndex<0) {
                return false;
            }
            index = foundIndex + 1;
        }
        return true;
    }
}
