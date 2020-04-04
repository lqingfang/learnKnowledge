package org.lqf.learn.leetCode.array.threeSum_15.threeSumClosest;

import java.util.Arrays;

/*
给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。

例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.

与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/3sum-closest
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public static void main(String[] args) {
        int[] array = {-1,-9,2,3,5,2,-4};
        int result = threeSumCloset(array,8);
        System.out.println(result);
    }

    private static int threeSumCloset(int[] array,int target) {
        Arrays.sort(array);
        int sumCloset = array[0]+array[1]+array[2];
        int minDiff = Math.abs(target-sumCloset);
        for(int i = 0;i<array.length-2;i++) {
            if(i>0 && array[i]==array[i-1]) {
                continue;
            }
            int left = i+1;
            int right = array.length-1;
            int currentTarget = target - array[i];
            while (left<right) {
                int diff = currentTarget - array[left] - array[right];
                if(diff == 0) {
                    return target;
                }
                if(Math.abs(diff)<minDiff) {
                    minDiff = Math.abs(diff);
                    sumCloset = array[i] + array[left] +array[right];
                }
                if(diff > 0){
                    do{
                        left++;
                    }while (left<right && array[left]==array[left+1]);
                }else {
                    do{
                        right--;
                    }while (left<right && array[right]==array[right-1]);
                }
            }
        }
        return sumCloset;
    }

}
