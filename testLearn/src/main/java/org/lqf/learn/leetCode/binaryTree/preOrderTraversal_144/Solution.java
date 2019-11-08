package org.lqf.learn.leetCode.binaryTree.preOrderTraversal_144;

import org.lqf.learn.leetCode.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
        List<Integer> list = preOrderTraversal(root);
        System.out.println(list);
    }

    private static List<Integer> preOrderTraversal(TreeNode root) {
        if(null == root) {
            return Collections.emptyList();
        }
        List<Integer> list = new ArrayList<>();
        list.add(root.val);
        List<Integer> leftList = preOrderTraversal(root.left);
        list.addAll(leftList);
        List<Integer> rightList = preOrderTraversal(root.right);
        list.addAll(rightList);
        return list;
    }
}
