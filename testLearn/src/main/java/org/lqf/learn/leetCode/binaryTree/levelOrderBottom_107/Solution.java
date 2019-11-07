package org.lqf.learn.leetCode.binaryTree.levelOrderBottom_107;

import org.lqf.learn.leetCode.binaryTree.TreeNode;

import java.util.*;

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

        System.out.println(levelOrderBottom(root));
    }

    private static List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(null == root) {
            return Collections.emptyList();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<List<Integer>> resultList = new ArrayList<>();
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int length = queue.size();
            for (int i=0;i<length;i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if(null != node.left) {
                    queue.add(node.left);
                }
                if(null != node.right) {
                    queue.add(node.right);
                }
            }
            resultList.add(0,list);
        }
        return resultList;
    }
}
