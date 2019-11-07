package org.lqf.learn.leetCode.binaryTree.averageOfLevels_637;

import org.lqf.learn.leetCode.binaryTree.TreeNode;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(8);
        TreeNode node3 = new TreeNode(11);
        TreeNode node4 = new TreeNode(13);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(7);
        TreeNode node7 = new TreeNode(2);
        TreeNode node8 = new TreeNode(1);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node5.right = node8;
        List<Double> list = averageOfLevels(root);
        System.out.println(list);
    }

    private static List<Double> averageOfLevels(TreeNode root) {
        if(null == root) {
            return Collections.emptyList();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        List<Double> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            int length = queue.size();
            double sum = 0;
            for(int i=0;i<length;i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                if(null != node.left) {
                    queue.add(node.left);
                }
                if(null != node.right) {
                    queue.add(node.right);
                }
            }
            list.add(sum/length);
        }
        return list;
    }
}
