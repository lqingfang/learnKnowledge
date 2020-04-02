package org.lqf.learn.leetCode.strString.findLongestWord_524;

import java.util.List;

public class Solution02 {
    public String findLongestWord(String s, List<String> d) {
        d.sort((o1,o2)->{
            int len1 = o1.length();
            int len2 = o2.length();
            if(len1 == len2) {
                return o1.compareTo(o2);
            }
            return len2 - len1;
        });
        for(String str:d) {
            if(match(str,s)) {
                return str;
            }
        }
        return "";
    }
    private boolean match(String str, String target) {
        int index = 0;
        char[] chars = str.toCharArray();
        for(char c:chars) {
            int findIndex = target.indexOf(c,index);
            if(findIndex < 0) {
                return false;
            }
            index = findIndex+1;
        }
        return true;
    }
}
