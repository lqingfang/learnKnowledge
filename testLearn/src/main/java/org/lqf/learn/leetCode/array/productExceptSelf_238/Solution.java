package org.lqf.learn.leetCode.array.productExceptSelf_238;

public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int multiply = 1;
        int zeroIndex = -1;
        for(int i=0;i<len;i++) {
            if(nums[i] !=0 || zeroIndex!=-1) {
                multiply *= nums[i];
            }else {
                zeroIndex = i;
                continue;
            }

        }
        if(zeroIndex != -1) {
            nums[zeroIndex] = multiply;
            for(int i=0;i<len;i++) {
                if(i != zeroIndex) {
                    nums[i] = 0;
                }
            }
        }else {
            for(int i=0;i<len;i++) {
                nums[i] = multiply/nums[i];
            }
        }

        return nums;
    }
}
