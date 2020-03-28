package org.lqf.learn.leetCode.linkedList.reverseList_206;

import org.lqf.learn.leetCode.linkedList.ListNode;


public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode res = new ListNode(-1);

        ListNode p = head;
        ListNode pre;
        while (p != null) {
            pre = p.next;
            p.next = res.next;
            res.next = p;
            p = pre;

        }
        return res.next;
    }
}
