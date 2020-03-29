package org.lqf.learn.leetCode.linkedList.getIntersectionNode_160;

import org.lqf.learn.leetCode.linkedList.ListNode;

public class Solution02 {
    public static void main(String[] args) {

    }
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) {
            return null;
        }
        ListNode tempA = headA;
        ListNode tempB = headB;
        while (tempA != tempB) {
            tempA = tempA == null? headB:tempA.next;
            tempB = tempB == null? headA:tempB.next;
        }
        return tempA;
    }
}
