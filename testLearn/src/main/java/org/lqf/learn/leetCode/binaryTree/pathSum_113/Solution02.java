package org.lqf.learn.leetCode.binaryTree.pathSum_113;

import org.lqf.learn.leetCode.binaryTree.TreeNode;

import java.util.*;

/**
 * bfs
 */
public class Solution02 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(-2);
        TreeNode node2 = new TreeNode(-3);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(-2);
        TreeNode node6 = new TreeNode(-1);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node3.left = node6;
        node2.left = node5;
        int sum = 2;
        List<List<Integer>> list = pathSum(root,sum);
        System.out.println(list);
    }
    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(null == root) {
            return Collections.emptyList();
        }
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> queueSum = new LinkedList<>();
        Queue<List<Integer>> queuelist = new LinkedList<>();
        queue.add(root);
        queueSum.add(root.val);
        List<Integer> list = new ArrayList<>();
        list.add(root.val);
        queuelist.add(list);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0;i<size;i++) {
                TreeNode poll = queue.poll();
                Integer curSum = queueSum.poll();
                List<Integer> curList = queuelist.poll();
                if(sum == curSum && poll.left == null && poll.right == null) {
                    res.add(curList);
                }
                if(poll.left != null) {
                    queue.add(poll.left);
                    queueSum.add(curSum+poll.left.val);
                    curList.add(poll.left.val);
                    queuelist.add(new ArrayList<>(curList));
                    curList.remove(curList.size()-1);
                }
                if(poll.right != null) {
                    queue.add(poll.right);
                    queueSum.add(curSum+poll.right.val);
                    curList.add(poll.right.val);
                    queuelist.add(new ArrayList<>(curList));
                    curList.remove(curList.size()-1);
                }
            }
        }
        return res;
    }
}
