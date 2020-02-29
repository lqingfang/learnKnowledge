package org.lqf.learn.leetCode.searchTree.sortedListToBST_109;

import org.lqf.learn.leetCode.searchTree.ListNode;
import org.lqf.learn.leetCode.searchTree.TreeNode;

public class Solution01 {
    public static void main(String[] args) {

    }
    public TreeNode sortedListToBST(ListNode head) {
        if(null == head) {
            return null;
        }
        ListNode midNode = dfs(head);
        TreeNode root = new TreeNode(midNode.val);
        if(head == midNode) {
            return root;
        }
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(midNode.next);
        return root;
    }

    private ListNode dfs(ListNode head) {
        ListNode pre = null;
        ListNode fastNode = head;
        ListNode slowNode = head;
        while (null != fastNode && null != fastNode.next) {
            pre = slowNode;
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }
        if(pre != null) {
            pre.next = null;
        }
        return slowNode;
    }
}
