package org.lqf.learn.leetCode.bitwise.isPowerOfTwo_231;

public class Solution {
    public static void main(String[] args) {

    }
    public boolean isPowerOfTwo(int n) {
        return n>0 && (n&(n-1)) !=0;
    }
}
