package org.lqf.learn.leetCode.linkedList.reverseBetween_92;

import org.lqf.learn.leetCode.linkedList.ListNode;

import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(5);
        node1.next = node2;
        ListNode res = reverseBetween(node1,1,2);
        System.out.println(res.val);
    }
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if(n==1) {
            return head;
        }
        Stack<Integer> stack = new Stack<>();
        ListNode p = head;
        int index = 1;
        ListNode pre = new ListNode(-1);
        while (index<m) {
            pre = p;
            p = p.next;
            index++;
        }

        while (index<=n) {
            stack.push(p.val);
            p = p.next;
            index++;
        }
        if(pre.val == -1) {
            head = pre;
        }
        while (!stack.isEmpty()) {
            ListNode node = new ListNode(stack.pop());
            pre.next = node;
            pre = pre.next;
        }
        pre.next = p;
        if(head.val == -1) {
            return head.next;
        }
        return head;
    }
}
