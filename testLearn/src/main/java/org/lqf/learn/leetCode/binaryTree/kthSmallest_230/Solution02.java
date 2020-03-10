package org.lqf.learn.leetCode.binaryTree.kthSmallest_230;

import org.lqf.learn.leetCode.binaryTree.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

/**
 * bfs
 */
public class Solution02 {
    public static void main(String[] args) {

    }
    public int kthSmallest(TreeNode root, int k) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        while (true) {
            while (null != root) {
                stack.add(root);
                root = root.left;
            }
            root = stack.removeLast();
            if(--k == 0) {
                return root.val;
            }
            root = root.right;
        }
    }
}
