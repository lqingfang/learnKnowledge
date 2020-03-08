package org.lqf.learn.leetCode.binaryTree.isSymmetric_101;

import org.lqf.learn.leetCode.binaryTree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution02 {
    public static void main(String[] args) {

    }
    public boolean isSymmetric(TreeNode root) {
        if(root == null) {
            return true;
        }
        Queue<TreeNode> leftQueue = new LinkedList<>();
        Queue<TreeNode> rightQueue = new LinkedList<>();
        leftQueue.add(root);
        rightQueue.add(root);
        while (!leftQueue.isEmpty()) {
            TreeNode leftNode = leftQueue.poll();
            TreeNode rightNode = rightQueue.poll();
            if(leftNode.val != rightNode.val) {
                return false;
            }
            if(leftNode.left != null && rightNode.right != null) {
                leftQueue.add(leftNode.left);
                rightQueue.add(rightNode.right);
            }
            if((leftNode.left == null && rightNode.right != null)|| (leftNode.left != null && rightNode.right == null)) {
                return false;
            }
            if(leftNode.right != null && rightNode.left != null) {
                leftQueue.add(leftNode.right);
                rightQueue.add(rightNode.left);
            }
            if((leftNode.right == null && rightNode.left != null) || (leftNode.right != null && rightNode.left == null)) {
                return false;
            }
        }
        return true;
    }
}
