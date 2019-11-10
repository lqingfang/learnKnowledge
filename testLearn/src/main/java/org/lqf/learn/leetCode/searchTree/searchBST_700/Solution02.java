package org.lqf.learn.leetCode.searchTree.searchBST_700;


import org.lqf.learn.leetCode.searchTree.TreeNode;
import java.util.Stack;

public class Solution02 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node5 = new TreeNode(15);
        TreeNode node6 = new TreeNode(14);
        TreeNode node7 = new TreeNode(17);
        root.left = node2;
        root.right = node5;
        node2.left = node1;
        node2.right = node3;
        node5.left = node6;
        node5.right = node7;

//        TreeNode root = new TreeNode(10);
//        TreeNode node1 = new TreeNode(10);
//        root.left = node1;
        int val = 15;
        System.out.println(searchBST(root,val));
    }

    private static TreeNode searchBST(TreeNode root, int val) {
        if(null != root) {
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                if(node.val == val) {
                    return node;
                }
                if(null != node.left) {
                    stack.push(node.left);
                }
                if(null != node.right) {
                    stack.push(node.right);
                }
            }
        }
        return null;
    }
}
