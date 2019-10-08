package org.lqf.learn.leetCode.arrayLearn.maxArea_11;

public class Solution02 {
    public static void main(String[] args) {
        int[] arrays = {2,4,3,6,1,9,8,7};
        System.out.println(maxArea(arrays));
    }
    private static int maxArea(int[] arrays) {
        int maxArea = 0;
        int left = 0;
        int right = arrays.length-1;
        while (left<right){
            int area = 0;
            if(arrays[left]<arrays[right]) {
                area = arrays[left] * (right-left);
                if(area>maxArea){
                    maxArea = area;
                }
                left++;
            }else{
                area = arrays[right] *(right-left);
                if(area>maxArea) {
                    maxArea = area;
                }
                right--;
            }
        }
        return maxArea;
    }
}
