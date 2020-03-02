package org.lqf.learn.leetCode.binaryTree.pathSum_113;

import org.lqf.learn.leetCode.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * dfs
 */
public class Solution01 {
    public static void main(String[] args) {

    }
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(root,sum,res,new ArrayList<>());
        return res;
    }

    private void dfs(TreeNode root, int sum, List<List<Integer>> res,List<Integer> list) {
        if(root == null){
            return;
        }
        list.add(root.val);
        if(root.left == null && root.right == null && root.val == sum) {
            res.add(new ArrayList<>(list));
        }

        if(root.left != null){
            dfs(root.left,sum-root.val,res,list);
        }
        if(root.right != null){
            dfs(root.right,sum-root.val,res,list);
        }
        list.remove(list.size()-1);
    }
}
