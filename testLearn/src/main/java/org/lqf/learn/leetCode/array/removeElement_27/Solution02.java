package org.lqf.learn.leetCode.array.removeElement_27;

import java.util.Arrays;

public class Solution02 {
    public static void main(String[] args) {
        int[] arrays = {3,2,3,4,5,2,1,8};
        int index = removeElements(arrays, 2);
        System.out.println(index);
        System.out.println(Arrays.toString(arrays));
    }

    private static int removeElements(int[] arrays, int key) {
        int left = 0;
        int right = arrays.length-1;
        while (left <right) {
            if(arrays[left] == key) {
                arrays[left] = arrays[right];
                right--;
            }else {
                left++;
            }
        }
        return right;
    }
}
