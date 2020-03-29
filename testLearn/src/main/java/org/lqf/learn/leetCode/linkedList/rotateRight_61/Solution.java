package org.lqf.learn.leetCode.linkedList.rotateRight_61;

import org.lqf.learn.leetCode.linkedList.ListNode;

public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(null == head || k==0) {
            return head;
        }
        int size = 0;
        ListNode p = head;
        ListNode last = null;
        while (p!= null) {
            size++;
            last = p;
            p = p.next;
        }
        int mv = k%size;
        if(mv == 0) {
            return head;
        }
        p = head;
        for(int i=0;i<size-mv-1;i++) {
            p = p.next;
        }
        ListNode next = p.next;
        p.next = null;
        last.next = head;
        head = next;
        return head;
    }
}
