package org.lqf.learn.leetCode.strString.myAtoi_8;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) {
        String str = "987 w";
        System.out.println(myAtoi(str));
    }
    final static Pattern pattern = Pattern.compile("[-+]??[0-9]++");
    public static int myAtoi(String str) {
        String strTrim = str.trim();
        Matcher matcher = pattern.matcher(strTrim);
        if(matcher.lookingAt()) {
            String strNum = strTrim.substring(0,matcher.end());
            try{
                return Integer.parseInt(strNum);
            } catch (NumberFormatException nfe) {
                return strNum.charAt(0) == '-'? Integer.MIN_VALUE:Integer.MAX_VALUE;
            }
        }
        return 0;
    }
}
