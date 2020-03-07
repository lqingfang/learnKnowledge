package org.lqf.learn.leetCode.binaryTree.isSubtree_572;

import org.lqf.learn.leetCode.binaryTree.TreeNode;

public class Solution01 {
    public static void main(String[] args) {

    }
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null && t == null) {
            return true;
        }
        if(s == null || t == null) {
            return false;
        }
        if(s.val == t.val){
            return (dfs(s,t) || isSubtree(s.left,t) || isSubtree(s.right,t));
        }
        return (isSubtree(s.left,t) || isSubtree(s.right,t));
    }
    public boolean dfs(TreeNode s, TreeNode t) {
        if(s == null && t == null) {
            return true;
        }
        if(s == null || t == null) {
            return false;
        }
        if(s.val == t.val) {
            if(dfs(s.left,t.left) && dfs(s.right,t.right)) {
                return true;
            }
        }
        return false;
    }
}
