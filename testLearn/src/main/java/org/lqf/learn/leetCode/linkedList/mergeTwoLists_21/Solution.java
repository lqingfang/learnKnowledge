package org.lqf.learn.leetCode.linkedList.mergeTwoLists_21;

import org.lqf.learn.leetCode.linkedList.ListNode;

public class Solution {
    public static void main(String[] args) {
        ListNode l2 = new ListNode(0);
        ListNode res = mergeTwoLists(null,l2);
        System.out.println(res.val);
    }
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
                cur = cur.next;
            }else {
                cur.next = l2;
                l2 = l2.next;
                cur = cur.next;
            }
        }
        if(l1 != null) {
            cur.next = l1;
        }
        if(l2!=null) {
            cur.next = l2;
        }
        return dummy.next;
    }
}
