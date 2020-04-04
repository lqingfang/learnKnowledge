package org.lqf.learn.leetCode.array.fourSum.fourSumArray;

import java.util.*;

/*
给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[l] = 0。

为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。所有整数的范围在 -228 到 228 - 1 之间，最终结果不会超过 231 - 1 。

例如:

输入:
A = [ 1, 2]
B = [-2,-1]
C = [-1, 2]
D = [ 0, 2]

输出:
2

解释:
两个元组如下:
1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/4sum-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

 */
public class Solution {
    public static void main(String[] args) {
        int[] A = {2,4,-1,0};
        int[] B = {1,-3,7,0};
        int[] C = {4,2,0,-9};
        int[] D = {2,-7,6,1};
        int result = fourSum(A, B, C, D);
        System.out.println(result);
    }
    public static int fourSum(int[] A,int[] B,int[] C,int[] D) {
        //遍历 A 和 B 所有元素和的组合情况，并记录在 ab_map 中，ab_map 的 key 为两数和，value 为该两数和出现的次数
        Map<Integer, Integer> sumAB = new HashMap<>();
        for (int a : A) {
            for (int b : B) {
                int sum = a + b;
                sumAB.put(sum, sumAB.getOrDefault(sum, 0) + 1);
            }
        }

        //遍历 C 和 D 所有元素和的组合情况，取和的负值判断其是否在 ab_map 中，若存在则取出 ab_map 对应的 value 值，count = count + value
        int counts = 0;
        for (int c : C) {
            for (int d : D) {
                int sum = c + d;
                counts += sumAB.getOrDefault(-sum, 0);
            }
        }

        return counts;
    }
}

