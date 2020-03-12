package org.lqf.learn.leetCode.binarySearch.postorderTraversal_145;

import org.lqf.learn.leetCode.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        if(null == root) {
            return Collections.emptyList();
        }
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            res.add(0,cur.val);
            if(cur.left != null) {
                stack.add(cur.left);
            }
            if(cur.right != null) {
                stack.add(cur.right);
            }
        }
        return res;
    }
}
