package org.lqf.learn.leetCode.array.sortedSquares_977;

import java.util.Arrays;

public class Solution {
    public int[] sortedSquares(int[] A) {
        int len = A.length;
        int[] newA = new int[len];
        for(int i=0;i<len;i++) {
            int newNum = A[i]*A[i];
            newA[i] = newNum;
        }
        Arrays.sort(newA);
        return newA;
    }
}
