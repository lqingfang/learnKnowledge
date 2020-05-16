package org.lqf.learn.leetCode.stackAndQueue.maxSlidingWindow_239;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 单调递减队列
 */
public class Solution02 {
    public static void main(String[] args) {
        int[] nums = {1,3,1,2,0,5};
        int k = 3;
        System.out.println(Arrays.toString(maxSlidingWindow(nums,k)));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        if(len <1) {
            return new int[0];
        }
        int[] res = new int[len-k+1];
        Deque<Integer> queue = new LinkedList<>();
        Deque<Integer> indexQueue = new LinkedList<>();
        int j=0;
        for(int i=0;i<len;i++) {
            if(queue.isEmpty()) {
                queue.add(nums[i]);
                indexQueue.add(i);
            } else {
                if(i- indexQueue.peek() == k) {
                    queue.poll();
                    indexQueue.poll();
                }
                while (!queue.isEmpty()) {
                    if(queue.peekLast() < nums[i]) {
                        queue.removeLast();
                        indexQueue.removeLast();
                    }else {
                        indexQueue.add(i);
                        queue.add(nums[i]);
                        break;
                    }
                }
                if(queue.isEmpty()) {
                    indexQueue.add(i);
                    queue.add(nums[i]);
                }
            }
            //如果已经有
            if(i+1 >=k) {
                res[j++] = queue.peek();
            }
        }
        return res;
    }

}
