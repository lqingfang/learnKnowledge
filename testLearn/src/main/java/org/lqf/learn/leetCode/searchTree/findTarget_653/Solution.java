package org.lqf.learn.leetCode.searchTree.findTarget_653;

import org.lqf.learn.leetCode.binaryTree.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node5 = new TreeNode(15);
        TreeNode node6 = new TreeNode(14);
        TreeNode node7 = new TreeNode(17);
        root.left = node2;
        root.right = node5;
        node2.left = node1;
        node2.right = node3;
        node5.left = node6;
        node5.right = node7;
        int k = 29;
        System.out.println(findTarget(root,k));
    }
    static List<Integer> list = new ArrayList<>();
    private static boolean findTarget(TreeNode root,int k) {
        inOrder(root);
        int head =0;
        int tail = list.size()-1;
        while (head<tail) {
            if(list.get(head) + list.get(tail) == k) {
                return true;
            }
            if(list.get(head) + list.get(tail) < k) {
                head++;
            }
            if(list.get(head) + list.get(tail) > k) {
                tail--;
            }
        }
        return false;
    }

    private static void inOrder(TreeNode root) {
        if(null == root) {
            return;
        }
        inOrder(root.left);
        if(null != root) {
            list.add(root.val);
        }
        inOrder(root.right);
    }
}
