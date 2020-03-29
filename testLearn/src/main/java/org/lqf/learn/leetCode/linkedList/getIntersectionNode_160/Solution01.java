package org.lqf.learn.leetCode.linkedList.getIntersectionNode_160;

import org.lqf.learn.leetCode.linkedList.ListNode;

public class Solution01 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) {
            return null;
        }
        int lenA = getLen(headA);
        int lenB = getLen(headB);
        while (lenA != lenB) {
            if(lenA > lenB) {
                headA = headA.next;
                lenA--;
            }else {
                headB = headB.next;
                lenB--;
            }
        }
        while (headA != null) {
            if(headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }

    private int getLen(ListNode headA) {
        int count = 0;
        while (headA!=null) {
            count++;
            headA = headA.next;
        }
        return count;
    }
}
