package org.lqf.learn.leetCode.binaryTree.binaryTreePaths_257;

import org.lqf.learn.leetCode.binaryTree.TreeNode;

import java.util.*;

public class Solution02 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(5);
        root.left = node1;
        root.right = node2;
        node1.right = node3;
        List<String> list = binaryTreePaths(root);
        System.out.println(list);
    }
    public static List<String> binaryTreePaths(TreeNode root) {
        if(null == root) {
            return Collections.emptyList();
        }
        List<String> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        Queue<StringBuilder> sbQueue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        sb.append(root.val);
        sbQueue.add(sb);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0;i<size;i++) {
                TreeNode curNode = queue.poll();
                StringBuilder curSb = sbQueue.poll();
                if(curNode.left == null && curNode.right == null) {
                    res.add(curSb.toString());
                }
                if(curNode.left != null) {
                    queue.add(curNode.left);
                    StringBuilder leftSb = new StringBuilder();
                    leftSb.append(curSb.toString()).append("->").append(curNode.left.val);
                    sbQueue.add(leftSb);
                }
                if(curNode.right != null) {
                    queue.add(curNode.right);
                    StringBuilder rightSb = new StringBuilder();
                    rightSb.append(curSb.toString()).append("->").append(curNode.right.val);
                    sbQueue.add(rightSb);
                }
            }
        }
        return res;
    }
}
