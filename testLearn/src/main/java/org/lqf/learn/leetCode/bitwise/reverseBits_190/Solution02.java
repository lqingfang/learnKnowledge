package org.lqf.learn.leetCode.bitwise.reverseBits_190;

public class Solution02 {
    public static void main(String[] args) {
        int n = 11;
        System.out.println(reverseBits(n));
    }
    public static int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result<<=1;
            result |=(n&1);
            n>>=1;
        }
        return result;
    }
}
