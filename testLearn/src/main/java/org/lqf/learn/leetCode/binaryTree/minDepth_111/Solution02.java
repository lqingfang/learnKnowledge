package org.lqf.learn.leetCode.binaryTree.minDepth_111;

import org.lqf.learn.leetCode.binaryTree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution02 {
    public static void main(String[] args) {

    }
    public int minDepth(TreeNode root) {
        if(null == root) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int deep = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            deep++;
            for(int i=0;i<size;i++) {
                TreeNode poll = queue.poll();
                if(poll.left== null && poll.right == null) {
                    return deep;
                }
                if(poll.left!=null) {
                    queue.add(poll.left);
                }
                if(poll.right != null) {
                    queue.add(poll.right);
                }
            }
        }
        return deep;
    }
}
