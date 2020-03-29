package org.lqf.learn.leetCode.linkedList.deleteDuplicates_82;

import org.lqf.learn.leetCode.linkedList.ListNode;

public class Solution {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(2);
        ListNode node6 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        ListNode res = deleteDuplicates(node1);
        System.out.println(res.val);
    }
    public static ListNode deleteDuplicates(ListNode head) {
        if(null == head) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            if(cur.next.val == cur.next.next.val) {
                ListNode temp = cur.next;
                while (temp != null && temp.next != null && temp.val == temp.next.val) {
                    temp = temp.next;
                }
                cur.next = temp.next;
            }else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}
