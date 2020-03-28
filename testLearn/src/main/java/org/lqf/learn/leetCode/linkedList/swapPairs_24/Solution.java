package org.lqf.learn.leetCode.linkedList.swapPairs_24;

import org.lqf.learn.leetCode.linkedList.ListNode;

/**
 * 递归
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode firstNode = head;
        ListNode secondNode = head.next;

        firstNode.next = swapPairs(secondNode.next);
        secondNode.next = firstNode;

        return secondNode;
    }
}
