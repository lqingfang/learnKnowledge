package org.lqf.learn.leetCode.linkedList.reverseKGroup_25;

import org.lqf.learn.leetCode.linkedList.ListNode;

public class Solution {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode res = reverseKGroup(node1,3);
        System.out.println(res.val);
    }
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode end = dummy;
        while (end.next != null) {
            for(int i=0;i<k && end != null;i++) {
                end = end.next;
            }
            if(end == null) {
                break;
            }
            ListNode start = pre.next;
            ListNode next = end.next;
            end.next = null;
            pre.next = reverse(start);
            start.next = next;
            pre = start;
            end = pre;
        }
        return dummy.next;
    }

    private static ListNode reverse(ListNode start) {
        ListNode pre = null;
        ListNode curr = start;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;

        }
        return pre;
    }
}
