package org.lqf.learn.leetCode.binaryTree.binaryTreePaths_257;

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
        List<String> list = binaryTreePaths(root);
        System.out.println(list);
    }

    private static List<String> binaryTreePaths(TreeNode root) {
        if(root == null) {
            return Collections.emptyList();
        }
        List<String> list = new ArrayList<>();

        if(null != root.left) {
            StringBuffer sb = new StringBuffer();
            sb.append(root.val);
            List<String> leftList = binaryTreePaths(root.left);
            for(String s:leftList) {
                s = sb.toString()+"->"+s;
                list.add(s);
            }
        }
        if(null != root.right) {
            StringBuffer sb = new StringBuffer();
            sb.append(root.val);
            List<String> rightList = binaryTreePaths(root.right);
            for(String s:rightList) {
                s = sb.toString()+"->"+s;
                list.add(s);
            }
        }
        if (null == root.left && null == root.right) {
            list.add(root.val+"");
        }
        return list;
    }
}
