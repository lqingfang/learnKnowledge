package org.lqf.learn.leetCode.linkedList.partition_86;

import org.lqf.learn.leetCode.linkedList.ListNode;

public class Solution {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode l1 = new ListNode(3);
        ListNode l2 = new ListNode(8);
        ListNode l3 = new ListNode(5);
        ListNode l4 = new ListNode(7);
        ListNode l5 = new ListNode(9);
        ListNode l6 = new ListNode(10);
        ListNode l7 = new ListNode(2);

        head.next = l1;
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;

        int x = 6;
        ListNode listNode = partition(head,x);
        listNode.print(listNode);
    }

    private static ListNode partition(ListNode head, int x) {
        if(null == head || null == head.next) {
            return head;
        }
        ListNode left = new ListNode(-1);
        ListNode toLeft = left;

        ListNode right = new ListNode(-1);
        ListNode toRight = right;
        while (null != head) {
            if(head.val < x) {
                toLeft.next = head;
                toLeft = toLeft.next;
            }else {
                toRight.next = head;
                toRight = toRight.next;
            }
            head = head.next;
        }
        toRight.next = null;
        toLeft.next = right.next;
        return left.next;
    }
}
