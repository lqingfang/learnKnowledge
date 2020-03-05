package org.lqf.learn.leetCode.binaryTree.sumNumbers_129;

import org.lqf.learn.leetCode.binaryTree.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

/**
 * bfs
 */
public class Solution02 {
    public static void main(String[] args) {

    }
    public int sumNumbers(TreeNode root) {
        if(null == root) {
            return 0;
        }
        int sum = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        Queue<Integer> sumQueue = new LinkedList<>();
        sumQueue.add(root.val);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0;i<size;i++) {
                TreeNode node = queue.poll();
                Integer cur = sumQueue.poll();
                if(node.left == null && node.right == null) {
                    sum +=cur;
                }
                if(node.left != null) {
                    queue.add(node.left);
                    sumQueue.add(cur*10+node.left.val);
                }
                if(node.right != null) {
                    queue.add(node.right);
                    sumQueue.add(cur*10+node.right.val);
                }
            }
        }
        return sum;
    }
}
