package org.lqf.learn.leetCode.bitwise.findComplement_476;

public class Solution {
    public static void main(String[] args) {

    }
    public int findComplement(int num) {
        int res = 0;
        int temp = 1;
        while (num>0) {
            if((num & 1)==0) {
                res = res | temp;
            }
            temp <<=1;
            num >>=1;
        }
        return res;
    }
}
