package org.lqf.learn.leetCode.linkedList.addTwoNumbers_445;

import org.lqf.learn.leetCode.linkedList.ListNode;

import java.util.Stack;

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        ListNode node1 = l1;
        while (node1 != null) {
            stack1.push(node1.val);
            node1 = node1.next;
        }

        ListNode node2 = l2;
        while (node2 != null) {
            stack2.push(node2.val);
            node2 = node2.next;
        }

        int tag = 0;
        int temp;
        ListNode head = null;
        while (!stack1.isEmpty() || !stack2.isEmpty() || tag != 0) {
            temp = 0;
            if(!stack1.isEmpty()) {
                temp += stack1.pop();
            }
            if(!stack2.isEmpty()) {
                temp += stack2.pop();
            }
            temp += tag;
            int currentVal = temp%10;
            tag = temp/10;
            ListNode node = new ListNode(currentVal);
            node.next = head;
            head = node;
        }
        return head;
    }
}
