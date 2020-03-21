package org.lqf.learn.leetCode.stackAndQueue.maxSlidingWindow_239;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 单调递减队列
 */
public class Solution03 {

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        if(len <1) {
            return new int[0];
        }
        int[] res = new int[len-k+1];
        //队列里面实际存的是序号
        Deque<Integer> indexQueue = new LinkedList<>();
        int j=0;
        for(int i=0;i<len;i++) {
            if(indexQueue.isEmpty()) {
                indexQueue.add(i);
            } else {
                //超过k个元素删掉
                if(i- indexQueue.peek() == k) {
                    indexQueue.poll();
                }
                while (!indexQueue.isEmpty()) {
                    if(nums[indexQueue.peekLast()] < nums[i]) {
                        indexQueue.removeLast();
                    }else {
                        indexQueue.add(i);
                        break;
                    }
                }
                if(indexQueue.isEmpty()) {
                    indexQueue.add(i);
                }
            }
            //已经遍历了k个，则需要添加结果集
            if(i+1 >=k) {
                res[j++] = nums[indexQueue.peek()];
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[] nums = {1,3,1,2,0,5};
        int k = 3;
        System.out.println(Arrays.toString(maxSlidingWindow(nums,k)));
    }
}
