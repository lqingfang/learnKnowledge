package org.lqf.learn.leetCode.binaryTree.findBottomLeftValue_513;

import org.lqf.learn.leetCode.binaryTree.TreeNode;

import java.util.*;

public class Solution01 {
    public static void main(String[] args) {

    }
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int value = -1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            value = queue.peek().val;
            for(int i=0;i<size;i++) {
                TreeNode node = queue.poll();
                if(null != node.left) {
                    queue.add(node.left);
                }
                if(null != node.right) {
                    queue.add(node.right);
                }
            }
        }
        return value;
    }
}
