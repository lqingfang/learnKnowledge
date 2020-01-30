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
            //得到所有可能的左子树
            List<TreeNode> left = dfs(start,i-1);
            //得到所有可能的右子树
            List<TreeNode> right = dfs(i+1,end);
            //左子树右子树结合
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
