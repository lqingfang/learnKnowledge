package org.lqf.learn.leetCode.strString.longestPalindrome_409;

public class Solution {
    public int longestPalindrome(String s) {
        int[] count = new int[128];
        for(int i=0;i<s.length();i++) {
            count[s.charAt(i)]++;
        }
        int res = 0;
        for(int n:count) {
            res += n/2*2;
            if(n%2==1 && res%2==0) {
                res++;
            }
        }
        return res;
    }
}
