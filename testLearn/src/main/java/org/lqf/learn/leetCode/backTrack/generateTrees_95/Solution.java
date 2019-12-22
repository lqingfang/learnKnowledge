package org.lqf.learn.leetCode.backTrack.generateTrees_95;

import org.lqf.learn.leetCode.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * dfs
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(generateTrees(3));
    }
    public static List<TreeNode> generateTrees(int n) {
        if(n ==0) {
            return Collections.emptyList();
        }
        return dfs(1,n);
    }

    private static List<TreeNode> dfs(int start, int end) {
        List<TreeNode> list = new ArrayList<>();
        if(start > end) {
            list.add(null);
            return list;
        }
        for(int i=start;i<=end;i++) {
            List<TreeNode> left = dfs(start,i-1);
            List<TreeNode> right = dfs(i+1,end);
            for (TreeNode leftNode : left) {
                for (TreeNode rightNode : right) {
                    TreeNode treeNode = new TreeNode(i);
                    treeNode.left = leftNode;
                    treeNode.right = rightNode;
                    list.add(treeNode);
                }
            }

        }
        return list;
    }
}
