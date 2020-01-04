package org.lqf.learn.leetCode.bitwise.reverseBits_190;

public class Solution {
    public static void main(String[] args) {
        int n = 43261596;
        System.out.println(reverseBits(n));
    }
    public static int reverseBits(int n) {
        int res = 0;
        int count = 0;
        while (count < 32) {
            res <<=1;
            res |=(n&1);
            n >>=1;
            count++;
        }
        return res;
    }
}
