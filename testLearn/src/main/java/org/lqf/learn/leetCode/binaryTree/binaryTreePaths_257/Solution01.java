package org.lqf.learn.leetCode.binaryTree.binaryTreePaths_257;

import org.lqf.learn.leetCode.binaryTree.TreeNode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * dfs 回溯
 */
public class Solution01 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(5);
        root.left = node1;
        root.right = node2;
        node1.right = node3;
        List<String> list = binaryTreePaths(root);
        System.out.println(list);
    }
    static List<String> res;
    public static List<String> binaryTreePaths(TreeNode root) {
        if(root == null) {
            return Collections.emptyList();
        }
        res = new ArrayList<>();
        dfs(root,new ArrayList<Integer>());
        return res;
    }
    public static void dfs(TreeNode node,List<Integer> list) {
        if(node == null) {
            return;
        }
        list.add(node.val);
        if(node.left == null && node.right == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(list.get(0));
            for(int i=1;i<list.size();i++) {
                sb.append("->").append(list.get(i));
            }
            res.add(sb.toString());
        } else {
            if(null != node.left) {
                dfs(node.left,list);
                list.remove(list.size()-1);
            }
            if(null != node.right) {
                dfs(node.right,list);
                list.remove(list.size()-1);
            }
        }
    }
}
