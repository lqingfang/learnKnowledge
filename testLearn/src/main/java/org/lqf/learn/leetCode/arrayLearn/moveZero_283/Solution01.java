package org.lqf.learn.leetCode.arrayLearn.moveZero_283;

import java.util.Arrays;

public class Solution01 {
    public static void main(String[] args) {
        int[] arrays = {0,2,3,0,12,7};
        moveZero(arrays);
        System.out.println(Arrays.toString(arrays));
    }

    private static void moveZero(int[] arrays) {
        int index = 0;
        for(int num:arrays){
            if(num == 0){
                continue;
            }
            arrays[index] = num;
            index++;
        }
        Arrays.fill(arrays,index,arrays.length,0);
    }
}
