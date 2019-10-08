package org.lqf.learn.leetCode.arrayLearn.removeDuplicates_80;

import java.util.Arrays;

public class Solution01 {
    public static void main(String[] args) {
        int[] arrays = {0,0,1,1,1,2,2,3,3,4,4,4,4};
        removeDuplicates(arrays);
        System.out.println(Arrays.toString(arrays));
    }
    private static void removeDuplicates(int[] arrsys) {
        int index = 2;
        for(int i=2;i<arrsys.length;i++) {
            if(arrsys[i] == arrsys[index-2]){
                continue;
            }
            arrsys[index] = arrsys[i];
            index++;
        }
    }
}
