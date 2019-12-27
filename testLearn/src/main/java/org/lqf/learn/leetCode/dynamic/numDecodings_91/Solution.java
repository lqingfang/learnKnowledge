package org.lqf.learn.leetCode.dynamic.numDecodings_91;

public class Solution {
    public static void main(String[] args) {

    }
    public int numDecodings(String s) {
        return decoding(0,s);
    }

    private int decoding(int start, String s) {
        if(start == s.length()) {
            return 1;
        }
        if(s.charAt(start) == '0') {
            return 0;
        }
        int ans1 = decoding(start+1,s);
        int ans2 = 0;
        if(start < s.length()-1) {
            int ten = (s.charAt(start) - '0')*10;
            int one = s.charAt(start+1) - '0';
            if(ten+one <= 26) {
                ans2 = decoding(start+2,s);
            }
        }
        return ans1 + ans2;
    }
}
