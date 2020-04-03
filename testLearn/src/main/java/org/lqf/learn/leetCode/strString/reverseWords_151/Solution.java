package org.lqf.learn.leetCode.strString.reverseWords_151;

public class Solution {
    public String reverseWords(String s) {
        String[] strArray = s.trim().split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=strArray.length-1;i>0;i--) {
            if(strArray[i].length() == 0) {
                continue;
            }
            stringBuilder.append(strArray[i]+" ");
        }
        stringBuilder.append(strArray[0]);
        return stringBuilder.toString();
    }
}
