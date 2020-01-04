package org.lqf.learn.leetCode.bitwise.countBits_338;

public class Solution {
    public static void main(String[] args) {

    }
    public int[] countBits(int num) {
        int[] res = new int[num+1];
        res[0] = 0;
        for(int i=1;i<=num;i++) {
            res[i] = res[i&(i-1)]+1;
        }
        return res;
    }
}
