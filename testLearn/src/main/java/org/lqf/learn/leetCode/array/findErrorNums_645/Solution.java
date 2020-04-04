package org.lqf.learn.leetCode.array.findErrorNums_645;

import java.util.Arrays;

import static org.lqf.learn.leetCode.array.moveZero_283.Solution02.swap;

public class Solution {
    public static void main(String[] args) {
        int[] arrays = {1,2,3,4,5,6,6,8};
        int[] errorNums = findErrorNums(arrays);
        System.out.println(Arrays.toString(errorNums));
    }

    private static int[] findErrorNums(int[] arrays) {
        for(int i = 0;i<arrays.length;i++) {
            if(arrays[i] != i+1 && arrays[arrays[i]-1] != arrays[i]) {
                swap(arrays,i,arrays[i]-1);
            }
        }
        for(int i= 0;i<arrays.length;i++) {
            if(arrays[i] != i+1) {
                return new int[]{arrays[i],i+1};
            }
        }
        return null;
    }
}
