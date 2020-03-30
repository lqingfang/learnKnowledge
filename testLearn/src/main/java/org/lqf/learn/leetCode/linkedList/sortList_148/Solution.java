package org.lqf.learn.leetCode.linkedList.sortList_148;

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
        ListNode res = sortList(node1);
        System.out.println(res.val);
    }
    public static ListNode sortList(ListNode head) {
        int size = 0;
        ListNode p = head;
        while (p != null) {
            size++;
            p= p.next;
        }
        ListNode fummy = new ListNode(0);
        fummy.next = head;
        for(int i=1;i<size;i *=2) {
            head = fummy;
            p = head.next;
            while (p!= null) {
                ListNode first = p;
                for (int j=1;j<i && p!=null;j++) {
                    p = p.next;
                }
                if(p == null) {
                    break;
                }
                ListNode second = p.next;
                p.next = null;
                p = second;
                for (int j=1;j<i && p!=null;j++) {
                    p = p.next;
                }
                ListNode thrid = null;
                if(p != null) {
                    thrid = p.next;
                    p.next = null;
                }

                p = thrid;
                ListNode temp = merge(first,second);
                head.next = temp;
                while (head.next != null) {
                    head = head.next;
                }
                head.next = thrid;
            }
        }
        return fummy.next;
    }

    private static ListNode merge(ListNode first, ListNode second) {
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        while (first != null && second != null) {
            if(first.val < second.val) {
                cur.next = first;
                first = first.next;
                cur = cur.next;
            }else {
                cur.next = second;
                second = second.next;
                cur = cur.next;
            }
        }
        if(first != null) {
            cur.next = first;
        }
        if(second != null) {
            cur.next = second;
        }
        return pre.next;
    }
}
