package org.lqf.learn.leetCode.linkedList.hasCycle_141;

import org.lqf.learn.leetCode.linkedList.ListNode;

public class Solution02 {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) {
            return false;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != slow) {
            if(fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
