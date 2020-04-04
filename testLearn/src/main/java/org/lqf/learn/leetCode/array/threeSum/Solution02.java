package org.lqf.learn.leetCode.array.threeSum;

import java.util.*;
/*
    基于双指针实现
*/
public class Solution02 {
    public static void main(String[] args) {
        int[] array = {-1,-1,-9,-1,2,3,5,2,-4,0};
        List<List<Integer>> lists = threeSum(array);
        System.out.println(lists);
    }
    public static List<List<Integer>> threeSum(int[] arrays) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(arrays);

        for(int i=0;i<arrays.length-2;i++){
            if(i>0 && arrays[i]==arrays[i-1]){
                continue;
            }
            int target = -arrays[i];
            int left = i+1;
            int right = arrays.length-1;
            while (left < right) {
                if(arrays[left]+arrays[right] == target) {
                    result.add(Arrays.asList(arrays[i],arrays[left],arrays[right]));
                    do{
                        left++;
                    }while (left<right && arrays[left] == arrays[left+1]);

                    do{
                        right--;
                    }while (left<right && arrays[right] == arrays[right-1]);
                    continue;
                }else if(arrays[left]+arrays[right] < target){
                    do{
                        left++;
                    }while (left<right && arrays[left] == arrays[left+1]);
                    continue;
                }else{
                    do{
                        right--;
                    }while (left<right && arrays[right] == arrays[right-1]);
                }
            }
        }
        return result;
    }
}
