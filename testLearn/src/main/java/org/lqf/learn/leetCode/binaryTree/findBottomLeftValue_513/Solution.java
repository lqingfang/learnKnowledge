package org.lqf.learn.leetCode.binaryTree.findBottomLeftValue_513;

import org.lqf.learn.leetCode.binaryTree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);
        root.left = node1;
        root.right = node2;
        node2.left = node3;
        node2.right = node4;

        System.out.println(findBottomLeftValue(root));
    }

    private static int findBottomLeftValue(TreeNode root) {
        if(null == root) {
            return -1;
        }
        int res = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int length = queue.size();
            res = queue.peek().val;
            for (int i=0;i<length;i++) {
                TreeNode node = queue.poll();
                if(null != node.left) {
                    queue.add(node.left);
                }
                if(null != node.right) {
                    queue.add(node.right);
                }
            }
        }
        return res;
    }

}
