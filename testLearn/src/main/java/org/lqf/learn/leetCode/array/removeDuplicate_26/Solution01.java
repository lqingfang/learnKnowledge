package org.lqf.learn.leetCode.array.removeDuplicate_26;

import java.util.Arrays;

public class Solution01 {
    public static void main(String[] args) {
        int[] arrays = {0,0,1,1,1,2,2,3,3,4};
        removeDuplicate(arrays);
        System.out.println(Arrays.toString(arrays));
    }
    private static int removeDuplicate(int[] arrsys) {
        int index = 1;
        for(int i=1;i<arrsys.length;i++){
            if(arrsys[i-1] == arrsys[i]) {
                continue;
            }
            arrsys[index] = arrsys[i];
            index++;
        }
        return index;
    }
}
