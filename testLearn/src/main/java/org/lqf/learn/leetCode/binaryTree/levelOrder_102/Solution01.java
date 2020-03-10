package org.lqf.learn.leetCode.binaryTree.levelOrder_102;

import org.lqf.learn.leetCode.binaryTree.TreeNode;

import java.util.*;

public class Solution01 {
    public static void main(String[] args) {

    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(null == root) {
            return Collections.emptyList();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<List<Integer>> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for(int i=0;i<size;i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if(null != node.left) {
                    queue.add(node.left);
                }
                if(null != node.right) {
                    queue.add(node.right);
                }
            }
            res.add(list);
        }
        return res;
    }
}
