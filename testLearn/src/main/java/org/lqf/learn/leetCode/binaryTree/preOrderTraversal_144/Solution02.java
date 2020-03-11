package org.lqf.learn.leetCode.binaryTree.preOrderTraversal_144;

import org.lqf.learn.leetCode.binaryTree.TreeNode;

import java.util.*;
/**
 * bfs
 */
public class Solution02 {
    public static void main(String[] args) {

    }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                res.add(cur.val);
                cur = cur.left;
            }
            cur = stack.pop();
            cur = cur.right;
        }
        return res;
    }
}
