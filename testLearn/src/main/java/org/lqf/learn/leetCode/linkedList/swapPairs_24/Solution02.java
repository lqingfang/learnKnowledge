package org.lqf.learn.leetCode.linkedList.swapPairs_24;

import org.lqf.learn.leetCode.linkedList.ListNode;

/**
 * 迭代
 */
public class Solution02 {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode preNode = dummy;

        while (head != null && head.next != null) {
            ListNode firstNode = head;
            ListNode secondNode = head.next;

            preNode.next = secondNode;
            firstNode.next = secondNode.next;
            secondNode.next = firstNode;
            preNode = firstNode;
            head = firstNode.next;

        }
        return dummy.next;
    }
}
