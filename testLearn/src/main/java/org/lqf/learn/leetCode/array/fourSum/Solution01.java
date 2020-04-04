package org.lqf.learn.leetCode.array.fourSum;

import java.util.*;
/*
给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。

注意：

答案中不可以包含重复的四元组。

示例：

给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。

满足要求的四元组集合为：
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/4sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution01 {
    public static void main(String[] args) {
        int[] array = {-1,-9,2,3,5,2,-4,0};
        List<List<Integer>> lists = fourSum(array,9);
        System.out.println(lists);
    }
    public static List<List<Integer>> fourSum(int[] arrays,int target) {
        Arrays.sort(arrays);
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0;i<arrays.length-3;i++){
            if(i>0 && arrays[i]==arrays[i-1]) {
                continue;
            }
            for(int j= i+1;j<arrays.length-2;j++){
                if(j-1!=i && arrays[j]==arrays[j-1]) {
                    continue;
                }
                int currentTarget = target-arrays[i]-arrays[j];
                int left = j+1;
                int right = arrays.length-1;
                while (left<right){
                    int sum = arrays[left]+arrays[right];
                    if(sum == currentTarget) {
                        result.add(Arrays.asList(arrays[i],arrays[j],arrays[left],arrays[right]));
                        do{
                            left++;
                        }while(left<right && arrays[left]==arrays[left-1]);
                        do{
                            right--;
                        }while (left<right && arrays[right] == arrays[right+1]);
                        continue;
                    }
                    if(sum < currentTarget) {
                        do{
                            left++;
                        }while(left<right && arrays[left]==arrays[left-1]);
                        continue;
                    }
                    do{
                        right--;
                    }while (left<right && arrays[right] == arrays[right+1]);
                }
            }
        }
        return result;
    }
}
