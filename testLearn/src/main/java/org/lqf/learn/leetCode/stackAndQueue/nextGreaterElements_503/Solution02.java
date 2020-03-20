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
        Stack<Integer> valueStack = new Stack<>();
        Stack<Integer> indexStack = new Stack<>();
        int len = nums.length;
        int[] res = new int[len];
        Arrays.fill(res,-1);
        for(int j=0;j<len*2-1;j++) {
            int i = j% len;
            if(valueStack.isEmpty()) {
                valueStack.add(nums[i]);
                indexStack.add(i);
            }else {
                while (!valueStack.isEmpty() && valueStack.peek() < nums[i]) {
                    valueStack.pop();
                    int index = indexStack.pop();
                    res[index] = nums[i];
                }
                valueStack.add(nums[i]);
                indexStack.add(i);
            }
        }
        return res;
    }
}
