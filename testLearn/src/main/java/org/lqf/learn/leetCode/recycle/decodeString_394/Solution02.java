package org.lqf.learn.leetCode.recycle.decodeString_394;

/**
 * 递归
 */
public class Solution02 {
    public static void main(String[] args) {
        System.out.println(decodeString("3[a2[c]]"));
    }

    static int i = 0;
    public static String decodeString(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        int len = s.length();
        if(len < 1) {
            return "";
        }
        char[] cs = s.toCharArray();
        while (i<len) {
            int times = 0;
            while (i<len && cs[i]>=0 && cs[i]<='9') {
                times = times*10 + cs[i]-'0';
                i++;
            }
            if(cs[i] == '[') {
                i++;
                String word = decodeString(s);
                while (times >0) {
                    stringBuilder.append(word);
                    times--;
                }
            }else if(cs[i] == ']') {
                i++;
                return stringBuilder.toString();
            }else {
                stringBuilder.append(cs[i]);
                i++;
            }
        }
        return stringBuilder.toString();
    }
}
