package org.lqf.learn.leetCode.linkedList.isPalindrome_234;

import org.lqf.learn.leetCode.linkedList.ListNode;

import java.util.Stack;

public class Solution {
    public boolean isPalindrome(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode p = head;
        while (p != null) {
            stack.push(p.val);
            p = p.next;
        }
        p = head;
        while (p != null) {
            if(p.val != stack.pop()) {
                return false;
            }
            p = p.next;
        }
        return true;
    }
}
