package org.lqf.learn.leetCode.linkedList.addEvenList_328;

import org.lqf.learn.leetCode.linkedList.ListNode;

public class Solution01 {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode one = head;
        ListNode twoF = head.next;
        ListNode two = twoF;
        while (two != null && two.next != null) {
            one.next = two.next;
            one = one.next;
            two.next = two.next.next;
            two = two.next;
        }
        one.next = twoF;
        return head;
    }
}
