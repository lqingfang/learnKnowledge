package org.lqf.learn.leetCode.bitwise.isPowerOfFour_342;

public class Solution {
    public static void main(String[] args) {

    }
    public boolean isPowerOfFour(int num) {
        return (num>0 && (num &(num-1))==0 && (num & 0xaaaaaaaa)==0);
    }
}
