package org.lqf.learn.leetCode.binaryTree.preOrderTraversal_144;

import org.lqf.learn.leetCode.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * dfs
 */
public class Solution01 {
    public static void main(String[] args) {

    }
    List<Integer> res;
    public List<Integer> preorderTraversal(TreeNode root) {
        if(null == root) {
            return Collections.emptyList();
        }
        res = new ArrayList<>();
        dfs(root);
        return res;
    }
    public void dfs(TreeNode node) {
        if(node == null) {
            return;
        }
        res.add(node.val);
        dfs(node.left);
        dfs(node.right);
    }
}
