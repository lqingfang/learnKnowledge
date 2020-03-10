package org.lqf.learn.leetCode.binaryTree.averageOfLevels_637;

import org.lqf.learn.leetCode.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution01 {
    public static void main(String[] args) {

    }
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Double> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            double sum = 0;
            for(int i=0;i<size;i++) {
                TreeNode node = queue.poll();
                if(null != node.left) {
                    queue.add(node.left);
                }
                if(null != node.right) {
                    queue.add(node.right);
                }
                sum+= node.val;
            }
            list.add(sum/size);
        }
        return list;
    }
}
