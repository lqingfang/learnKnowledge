package org.lqf.learn.leetCode.bitwise.hammingWeight_191;

public class Solution {
    public static void main(String[] args) {

    }
    public int hammingWeight(int n) {
        int count=0;
        while (n != 0) {
            count++;
            n = n&(n-1);
        }
        return count;
    }
}
