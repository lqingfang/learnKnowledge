package org.lqf.learn.leetCode.searchTree.isValidBST_98;

import org.lqf.learn.leetCode.searchTree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * bfs
 */
public class Solution02 {
    public static void main(String[] args) {

    }
    static Queue<TreeNode> queue;
    public boolean isValidBST(TreeNode root) {
        if(null == root) {
            return true;
        }
        queue = new LinkedList<>();
        bfs(root);
        TreeNode poll = queue.poll();
        int pre = poll.val;
        while (!queue.isEmpty()) {
            TreeNode poll1 = queue.poll();
            int cur = poll1.val;
            if(pre>=cur) {
                return false;
            }
            pre = cur;
        }
        return true;
    }

    private void bfs(TreeNode root) {
        if(root == null) {
            return;
        }
        if(null != root.left) {
            bfs(root.left);
        }
        queue.add(root);
        if(null != root.right) {
            bfs(root.right);
        }
    }
}
