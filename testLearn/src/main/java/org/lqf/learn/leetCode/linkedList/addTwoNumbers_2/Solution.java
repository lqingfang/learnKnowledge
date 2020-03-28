package org.lqf.learn.leetCode.linkedList.addTwoNumbers_2;

import org.lqf.learn.leetCode.linkedList.ListNode;

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode p = head;
        int tag = 0;
        while (l1 !=null || l2 != null) {
            int temp;
            if(l1 == null) {
                temp = l2.val+tag;
                l2 = l2.next;
            }else if(l2 == null) {
                temp = l1.val+tag;
                l1 = l1.next;
            }else {
                temp = l1.val + l2.val+tag;
                l1 = l1.next;
                l2 = l2.next;
            }
            int currentVal = temp%10;
            tag = temp/10;
            ListNode node = new ListNode(currentVal);
            p.next = node;
            p = p.next;
        }
        if(tag != 0) {
            ListNode node = new ListNode(tag);
            p.next = node;
        }

        return head.next;
    }
}
