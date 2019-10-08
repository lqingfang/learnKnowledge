package org.lqf.learn.leetCode.arrayLearn.moveZero_283;

import java.util.Arrays;

public class Solution02 {
    public static void main(String[] args) {
        int[] arrays = {0,2,3,0,12,7};
        moveZero(arrays);
        System.out.println(Arrays.toString(arrays));
    }

    private static void moveZero(int[] arrays) {
        int lastZeroIndex = 0;
        for(int i=0;i<arrays.length;i++) {
            if(arrays[i] == 0){
                continue;
            }
            swap(arrays,lastZeroIndex,i);
            lastZeroIndex++;
        }
    }
    public static void swap(int[] arrays,int lastZeroIndex,int i) {
        int temp = arrays[lastZeroIndex];
        arrays[lastZeroIndex] = arrays[i];
        arrays[i] = temp;
    }
}
