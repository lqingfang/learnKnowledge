package org.lqf.learn.leetCode.binaryTree.isSameTree_100;

import org.lqf.learn.leetCode.binaryTree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * bfs
 */
public class Solution02 {
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        //TreeNode node2 = new TreeNode(3);
        root1.left = node1;
        //root1.right = node2;

        TreeNode root2 = new TreeNode(1);
        TreeNode node11 = new TreeNode(2);
        //TreeNode node22 = new TreeNode(3);
        root2.left = node11;
        //root2.right = node22;

        System.out.println(isSameTree(root1,root2));
    }
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) {
            return true;
        }
        if(p == null || q == null) {
            return false;
        }
        Queue<TreeNode> pQueue = new LinkedList<>();
        Queue<TreeNode> qQueue = new LinkedList<>();
        pQueue.add(p);
        qQueue.add(q);

        while (!pQueue.isEmpty()) {
            TreeNode pNode = pQueue.poll();
            TreeNode qNode = qQueue.poll();
            if(pNode.val != qNode.val) {
                return false;
            }
            if(pNode.left != null && qNode.left!=null) {
                pQueue.add(pNode.left);
                qQueue.add(qNode.left);
            }
            if((pNode.left == null && qNode.left!=null) || (pNode.left != null && qNode.left==null)) {
                return false;
            }
            if(pNode.right != null && qNode.right!=null) {
                pQueue.add(pNode.right);
                qQueue.add(qNode.right);
            }
            if((pNode.right == null && qNode.right!=null) || (pNode.right != null && qNode.right==null)) {
                return false;
            }
        }
        return true;
    }
}
