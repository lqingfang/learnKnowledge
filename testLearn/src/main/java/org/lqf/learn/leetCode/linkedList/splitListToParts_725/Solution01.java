package org.lqf.learn.leetCode.linkedList.splitListToParts_725;

import org.lqf.learn.leetCode.linkedList.ListNode;

import java.util.Arrays;

public class Solution01 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        //ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        //node4.next = node5;
        ListNode[] res = splitListToParts(node1,5);
        System.out.println(Arrays.toString(res));
    }
    public static ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] res = new ListNode[k];
        if(root == null) {
            return res;
        }
        int size = 0;
        ListNode p = root;
        while (p != null) {
            size++;
            p = p.next;
        }
        int m = size%k;
        int n = size/k;
        p = root;
        ListNode pre = p;
        //有k组
        for(int i=0;i<k;i++) {
            res[i] = p;
            //每组至少有n个
            int x = n;
            if(m>0) {
                x += 1;
                m--;
            }
            for(int j=0;j<x;j++) {
                pre = p;
                p = p.next;
            }
            pre.next = null;
        }
        return res;
    }
}
