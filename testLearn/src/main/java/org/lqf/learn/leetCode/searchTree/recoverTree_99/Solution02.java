package org.lqf.learn.leetCode.searchTree.recoverTree_99;

import org.lqf.learn.leetCode.searchTree.TreeNode;

public class Solution02 {
    public static void main(String[] args) {

    }
    TreeNode preNode = null;
    int x = -1;
    int y = -1;
    public void recoverTree(TreeNode root) {
        if(null == root) {
            return;
        }
        findErrorNum(root);
        reDfs(root);
    }

    private void reDfs(TreeNode root) {
        if(null == root) {
            return;
        }
        if(root.val == x || root.val == y) {
            if(root.val == x) {
                root.val = y;
            }else {
                root.val = x;
            }
        }
        reDfs(root.left);
        reDfs(root.right);
    }

    public void findErrorNum(TreeNode node) {
        if(null == node) {
            return;
        }
        findErrorNum(node.left);
        if(preNode != null && preNode.val > node.val) {
            y = node.val;
            if(x != -1) {
                return;
            }
            x = preNode.val;
        }
        preNode = node;
        findErrorNum(node.right);
    }
}
