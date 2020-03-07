package org.lqf.learn.leetCode.binaryTree.invertTree_226;

import org.lqf.learn.leetCode.binaryTree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * bfs
 */
public class Solution02 {
    public static void main(String[] args) {

    }
    public TreeNode invertTree(TreeNode root) {
        if(root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if(null == node) {
                continue;
            }
            TreeNode tempNode = node.left;
            node.left = node.right;
            node.right = tempNode;
            queue.add(node.left);
            queue.add(node.right);
        }
        return root;
    }
}
