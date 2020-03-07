package org.lqf.learn.leetCode.binaryTree.mergeTrees_617;

import org.lqf.learn.leetCode.binaryTree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * bfs
 * 一、总体思路
 *
 * 对比t1和t2两棵树的差异；
 * 将t2合并到t1；
 * 返回t1。
 * 二、详细设计
 * 选择一种树的遍历方式，执行以下步骤
 *
 * 遍历t2，同步遍历t1，对比相同位置的节点差异；
 * t2有而t1没有的节点，则给t1创建一个；
 * t2有而t1也有的节点，将两个值相加，更新t1的节点值。
 */
public class Solution02 {
    public static void main(String[] args) {

    }
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null) {
            return null;
        }
        if(t1 == null && t2 != null) {
            return t2;
        }
        if(t1 != null && t2 == null) {
            return t1;
        }
        Queue<TreeNode> t1Queue = new LinkedList<>();
        Queue<TreeNode> t2Queue = new LinkedList<>();
        t1Queue.add(t1);
        t2Queue.add(t2);
        while (!t2Queue.isEmpty()) {
            TreeNode t1Node = t1Queue.poll();
            TreeNode t2Node = t2Queue.poll();
            t1Node.val +=t2Node.val;
            if(t2Node.left != null) {
                if(t1Node.left == null) {
                    t1Node.left = new TreeNode(0);
                }
                t1Queue.add(t1Node.left);
                t2Queue.add(t2Node.left);
            }
            if(t2Node.right != null) {
                if(t1Node.right == null) {
                    t1Node.right = new TreeNode(0);
                }
                t1Queue.add(t1Node.right);
                t2Queue.add(t2Node.right);
            }
        }
        return t1;
    }
}
