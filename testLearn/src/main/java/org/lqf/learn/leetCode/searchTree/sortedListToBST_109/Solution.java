package org.lqf.learn.leetCode.searchTree.sortedListToBST_109;

import org.lqf.learn.leetCode.linkedList.ListNode;
import org.lqf.learn.leetCode.searchTree.TreeNode;

public class Solution {
    public static void main(String[] args) {
        ListNode head = new ListNode(-1);
        ListNode l1 = new ListNode(3);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(5);
        ListNode l4 = new ListNode(7);
        ListNode l5 = new ListNode(9);
        ListNode l6 = new ListNode(10);
        ListNode l7 = new ListNode(20);

        head.next = l1;
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;

        sortedListToBST(head);
    }

    private static TreeNode sortedListToBST(ListNode head) {
        if(null == head) {
            return null;
        }
        ListNode midNode = getTreeNode(head);
        TreeNode root = new TreeNode(midNode.val);
        if(head == midNode) {
            return root;
        }
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(midNode.next);
        return root;
    }

    private static ListNode getTreeNode(ListNode head) {
        ListNode preNode = null;
        ListNode slowNode = head;
        ListNode fastNode = head;
        while (fastNode != null && fastNode.next != null) {
            preNode = slowNode;
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }
        if(preNode != null) {
            preNode.next = null;
        }

        return slowNode;
    }
}
