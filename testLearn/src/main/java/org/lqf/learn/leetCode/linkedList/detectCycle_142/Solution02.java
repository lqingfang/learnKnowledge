package org.lqf.learn.leetCode.linkedList.detectCycle_142;

import org.lqf.learn.leetCode.linkedList.ListNode;

public class Solution02 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;
        ListNode res = detectCycle(node1);
        System.out.println(res.val);
    }
    public static ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null) {
            return null;
        }
        ListNode meetNode = getMeetNode(head);
        if(meetNode == null) {
            return null;
        }
        ListNode fast = meetNode;
        ListNode slow = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
    public static ListNode getMeetNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow) {
                return fast;
            }
        }
        return null;
    }
}
