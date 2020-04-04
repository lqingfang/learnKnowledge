package org.lqf.learn.leetCode.array.threeSum;

import java.util.*;
/*
给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。

注意：答案中不可以包含重复的三元组。

例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，

满足要求的三元组集合为：
[
  [-1, 0, 1],
  [-1, -1, 2]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/3sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
-----------------
基于多次一遍哈希实现
 */
public class Solution01 {
    public static void main(String[] args) {
        int[] array = {-1,-9,2,3,5,2,-4,0};
        List<List<Integer>> lists = threeSum(array);
        System.out.println(lists);
    }
    public static List<List<Integer>> threeSum(int[] arrays) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(arrays);
        for(int i=0;i<arrays.length-2;i++) {
            if(i>0 && arrays[i]==arrays[i-1]){
                continue;
            }
            int target = -arrays[i];
            Map<Integer,Integer> indexValueMap = new HashMap<>();
            for(int j=i+1;j<arrays.length;j++){
                if(j+1<arrays.length && arrays[j] == arrays[j+1]) {
                    indexValueMap.put(arrays[j],j);
                    continue;
                }
                Integer integer = indexValueMap.get(target - arrays[j]);
                if(null != integer) {
                    result.add(Arrays.asList(arrays[i],arrays[j],arrays[integer]));
                }else{
                    indexValueMap.put(arrays[j],j);
                }
            }
        }
        return result;
    }
}
