package org.lqf.learn.leetCode.binaryTree.pathSum_113;

import org.lqf.learn.leetCode.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(8);
        TreeNode node3 = new TreeNode(11);
        TreeNode node4 = new TreeNode(13);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(7);
        TreeNode node7 = new TreeNode(2);
        TreeNode node8 = new TreeNode(1);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node5.right = node8;
        int sum = 22;
        List<List<Integer>> list = pathSum(root,sum);
        System.out.println(list);
    }

    private static List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(null == root){
            return Collections.emptyList();
        }
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> tmpList = new ArrayList<>();
        pathSonSum(root,sum,tmpList,list);

        return list;
    }

    private static void pathSonSum(TreeNode root, int sum, List<Integer> tmpList,List<List<Integer>> list) {
        if(null == root) {
            return;
        }
        tmpList.add(root.val);
        if(root.val == sum && null == root.left && null == root.right) {
            list.add(new ArrayList<>(tmpList));
        }
        sum = sum - root.val;

        if(null != root.left) {
            pathSonSum(root.left,sum,tmpList,list);
        }
        if(null != root.right) {
            pathSonSum(root.right,sum,tmpList,list);
        }
        tmpList.remove(tmpList.size()-1);
    }

}
