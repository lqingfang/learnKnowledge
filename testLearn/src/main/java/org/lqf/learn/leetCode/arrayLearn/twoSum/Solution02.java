package org.lqf.learn.leetCode.arrayLearn.twoSum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
/*
给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。

你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。

示例:

给定 nums = [2, 7, 11, 15], target = 9

因为 nums[0] + nums[1] = 2 + 7 = 9
所以返回 [0, 1]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/two-sum
 */
public class Solution02 {
    public static void main(String[] args) {
        int[] arry = {2,5,4,6,8,1};
        int[] result = twoSum(arry,9);
        System.out.println(Arrays.toString(result));
    }
    public static int[] twoSum(int[] arry,int sum) {
        Map<Integer,Integer> valueIndex = new HashMap<Integer,Integer>();

        for(int i=0;i<arry.length;i++){
            int wantNum = sum - arry[i];
            Integer integer = valueIndex.get(wantNum);
            if(null != integer) {
                return new int[]{i,integer};
            }
            valueIndex.put(arry[i],i);
        }
        return new int[]{-1,-1};
    }
}
