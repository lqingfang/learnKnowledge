package org.lqf.learn.leetCode.linkedList.deleteDuplicates_83;

import org.lqf.learn.leetCode.linkedList.ListNode;

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(null == head) {
            return head;
        }
        ListNode p = head.next;
        ListNode pre = head;
        while (p!=null) {
            if(p.val == pre.val) {
                pre.next = p.next;
                p = p.next;
            }else {
                pre = p;
                p = p.next;
            }
        }
        return head;
    }
}
