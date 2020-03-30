package org.lqf.learn.leetCode.linkedList.insertionSortList_147;

import org.lqf.learn.leetCode.linkedList.ListNode;

public class Solution {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;
        ListNode res = insertionSortList(node1);
        System.out.println(res.val);
    }
    public static ListNode insertionSortList(ListNode head) {
        if(head == null) {
            return null;
        }
        ListNode fummy = new ListNode(0);
        ListNode pre = fummy;
        ListNode cur = head;
        while (null != cur) {
            pre = fummy;
            while (pre.next != null && pre.next.val < cur.val) {
                pre = pre.next;
            }
            ListNode next = cur.next;
            cur.next = pre.next;
            pre.next = cur;
            cur = next;
        }
        return fummy.next;
    }
}
