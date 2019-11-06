package org.lqf.learn.leetCode.binaryTree.leafSimilar_872;

import org.lqf.learn.leetCode.binaryTree.TreeNode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);
        root1.left = node1;
        root1.right = node2;
        node2.left = node3;
        node2.right = node4;

        TreeNode root2 = new TreeNode(3);
        TreeNode node5 = new TreeNode(9);
        TreeNode node6 = new TreeNode(20);
        TreeNode node7 = new TreeNode(15);
        TreeNode node8 = new TreeNode(7);
        root2.left = node5;
        root2.right = node6;
        node5.left = node7;
        node5.right = node8;

        System.out.println(leafSimilar(root1,root2));
    }

    private static boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = getLeaf(root1);
        List<Integer> list2 = getLeaf(root2);
        if(list1.size() != list2.size()) {
            return false;
        }
        for(int i=0;i<list1.size();i++) {
            if(list1.get(i) != list2.get(i)) {
                return false;
            }
        }
        return true;
    }

    private static List<Integer> getLeaf(TreeNode node) {
        List<Integer> list = new ArrayList<>();
        if(null == node) {
            return Collections.emptyList();
        }
        if(null == node.left && null == node.right) {
            list.add(node.val);
        }
        list.addAll(getLeaf(node.left));
        list.addAll(getLeaf(node.right));
        return list;
    }
}
