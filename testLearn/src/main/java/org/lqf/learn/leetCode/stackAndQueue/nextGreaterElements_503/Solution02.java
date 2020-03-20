package org.lqf.learn.leetCode.stackAndQueue.nextGreaterElements_503;

import java.util.Arrays;
import java.util.Stack;

/**
 * 没明白  单调栈
 */
public class Solution02 {
    public static void main(String[] args) {
        int[] array = new int[]{5,4,3,2,1};
        int[] res = nextGreaterElements(array);
        System.out.println(Arrays.toString(res));
    }

    public static int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 2 * nums.length - 1; i >= 0; --i) {
            while (!stack.empty() && nums[stack.peek()] <= nums[i % nums.length]) {
                stack.pop();
            }
            res[i % nums.length] = stack.empty() ? -1 : nums[stack.peek()];
            stack.push(i % nums.length);
        }
        return res;
    }
}
