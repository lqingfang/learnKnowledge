package org.lqf.learn.leetCode.binaryTree.sumNumbers_129;

import org.lqf.learn.leetCode.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * dfs
 */
public class Solution01 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        root.left = node1;
        root.right = node2;
        System.out.println(sumNumbers(root));
    }
    static int sum;
    static List<List<Integer>> res;
    public static int sumNumbers(TreeNode root) {
        if(null == root) {
            return 0;
        }
        sum = 0;
        res = new ArrayList<>();
        dfs(root,new ArrayList<Integer>());
        for(int i=0;i<res.size();i++) {
            int cur = 0;
            List<Integer> list = res.get(i);
            for(int j=0;j<list.size();j++) {
                cur = cur*10+list.get(j);
            }
            sum += cur;
        }
        return sum;
    }
    public static void dfs(TreeNode node, List<Integer> list) {
        if(null == node) {
            return;
        }
        list.add(node.val);
        if(node.left == null && node.right == null) {
            res.add(new ArrayList<>(list));
            return;
        }
        if(node.left != null) {
            dfs(node.left,list);
            list.remove(list.size()-1);
        }
        if(node.right != null) {
            dfs(node.right,list);
            list.remove(list.size()-1);
        }
    }
}
