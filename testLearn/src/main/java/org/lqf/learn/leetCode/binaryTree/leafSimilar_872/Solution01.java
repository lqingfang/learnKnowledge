package org.lqf.learn.leetCode.binaryTree.leafSimilar_872;

import org.lqf.learn.leetCode.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution01 {
    public static void main(String[] args) {

    }
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null) {
            return true;
        }
        if(root1 == null || root2 == null) {
            return false;
        }
        List<Integer> root1List = new ArrayList<>();
        List<Integer> root2List = new ArrayList<>();
        dfs(root1,root1List);
        dfs(root2,root2List);
        int size1 = root1List.size();
        int size2 = root2List.size();
        if(size1 != size2) {
            return false;
        }
        for(int i=0;i<size1;i++) {
            if(root1List.get(i) != root2List.get(i)) {
                return false;
            }
        }
        return true;
    }
    public void dfs(TreeNode node,List<Integer> list) {
        if(node == null) {
            return;
        }
        dfs(node.left,list);
        if(node.left == null && node.right == null) {
            list.add(node.val);
        }
        dfs(node.right,list);
    }
}
