package org.lqf.learn.leetCode.bitwise.singleNumber_260;

import java.util.Arrays;

/**
    没明白
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = {1,2,1,3,2,5};
        int[] res = singleNumber(nums);
        System.out.println(Arrays.toString(res));
    }
    public static int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int i : nums)// 一样的抵消,不一样的两个数字异或运算结果必定有一位是1
            xor ^= i;

        int mask = xor & (-xor);

        int[] ans = new int[2];
        for (int i : nums) {
            if ((i & mask) == 0)//== 0、 == mask 两种结果
                ans[0] ^= i;
            else
                ans[1] ^= i;
        }

        return ans;
    }
}
