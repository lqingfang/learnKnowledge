package org.lqf.learn.leetCode.linkedList.splitListToParts_725;

import org.lqf.learn.leetCode.linkedList.ListNode;

public class Solution {
    public static void main(String[] args) {

        ListNode root = new ListNode(1);
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(3);
        ListNode l3 = new ListNode(4);
        ListNode l4 = new ListNode(7);
        ListNode l5 = new ListNode(9);
        ListNode l6 = new ListNode(10);
        ListNode l7 = new ListNode(12);

        root.next = l1;
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;

        int k = 7;
        ListNode[] listNodes = splitListToParts(root, k);
        for(int i=0;i<listNodes.length;i++) {
            listNodes[i].print(listNodes[i]);
        }
    }

    private static ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] listNodes = new ListNode[k];
        if(null == root) {
            return listNodes;
        }
        int length = 0;
        ListNode p = root;
        while (null != p) {
            length++;
            p = p.next;
        }

        p = root;
        int index = 0;
        if(k>=length) {
            while (null != p) {
                ListNode cur = p;
                p = p.next;
                cur.next = null;
                listNodes[index] = cur;
                index++;
            }
            return listNodes;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = root;
        index = 0;

        int moreAmount = length%k;
        int lessAmount = k - moreAmount;
        int lessLength = length/k;
        int moreLength = lessLength+1;

        for(int i=0;i<moreAmount;i++){
            ListNode cur = dummy.next;
            for(int j=0;j<moreLength-1;j++) {
                cur = cur.next;
            }
            listNodes[index] = dummy.next;
            dummy.next = cur.next;
            cur.next = null;
            index++;
        }
        for(int i=0;i<lessAmount;i++){
            ListNode cur = dummy.next;
            for(int j=0;j<lessLength-1;j++) {
                cur = cur.next;
            }
            listNodes[index] = dummy.next;
            dummy.next = cur.next;
            cur.next = null;
            index++;
        }
        return listNodes;
    }
}
