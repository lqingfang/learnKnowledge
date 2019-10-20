package org.lqf.learn.leetCode.linkedList.addEvenList_328;

import org.lqf.learn.leetCode.linkedList.ListNode;

public class Solution {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(3);
        ListNode l3 = new ListNode(4);
        ListNode l4 = new ListNode(7);
        ListNode l5 = new ListNode(9);
        ListNode l6 = new ListNode(10);
        ListNode l7 = new ListNode(12);

        head.next = l1;
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;

        ListNode listNode = addEvenList(head);
        listNode.print(listNode);
    }

    private static ListNode addEvenList(ListNode head) {
        if(null == head || null == head.next) {
            return head;
        }
        ListNode odd = head;
        ListNode evenF = head.next;
        ListNode even = evenF;
        while (null != even && null != even.next) {
            odd.next = even.next;
            odd = odd.next;
            even.next = even.next.next;
            even = even.next;
        }
        odd.next = evenF;
        return head;
    }
}
