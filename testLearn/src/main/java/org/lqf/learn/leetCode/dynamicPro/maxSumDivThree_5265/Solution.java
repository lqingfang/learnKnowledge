package org.lqf.learn.leetCode.dynamicPro.maxSumDivThree_5265;

import java.util.ArrayList;
import java.util.List;

/*
没有通过，没有考虑 一个组内 满足的情况，比较大小
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = new int[]{
                1,2,3,4,4
        };
        System.out.println(maxSumDivThree(nums));
    }
    public static int maxSumDivThree(int[] nums) {
        int sum = 0;
        List<Integer> one = new ArrayList();
        List<Integer> two = new ArrayList();
        for(int i=0;i<nums.length;i++) {
            if(nums[i] % 3==0) {
                sum+=nums[i];
            }else if(nums[i] %3 ==2){
                two.add(nums[i]);
            }else if(nums[i] %3 ==1){
                one.add(nums[i]);
            }
        }
        int oneRight = one.size()-1;
        int twoRight = two.size()-1;
        while (oneRight>=0 && twoRight>=0) {
            sum+= one.get(oneRight)+two.get(twoRight);
            oneRight--;
            twoRight--;
        }
        int oneP = oneRight%3;
        while (oneRight>oneP) {
            sum += one.get(oneRight);
            oneRight--;
        }
        int twoP = twoRight%3;
        while (twoRight>twoP) {
            sum += two.get(twoRight);
            twoRight--;
        }
        return sum;
    }
}
