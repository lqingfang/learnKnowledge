package org.lqf.learn.leetCode.searchTree.findMode_501;

import org.lqf.learn.leetCode.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(0);
        TreeNode node4 = new TreeNode(0);
        TreeNode node5 = new TreeNode(0);
//        TreeNode node6 = new TreeNode(7);
//        TreeNode node7 = new TreeNode(2);
//        TreeNode node8 = new TreeNode(1);
        //root.left = node1;
//        root.left = node3;
//        node3.left = node4;
        //node4.left = node5;
        root.right = node1;
//        node1.left = node2;
//        node1.left = node3;
//        node2.left = node4;
//        node2.right = node5;
//        node3.left = node6;
//        node3.right = node7;
//        node5.right = node8;
        int[] arr = findMode(root);
        System.out.println(Arrays.toString(arr));
    }

    static Integer maxTime = 0;
    static Integer curTime = 1;
    static Integer preNum = null;
    static List<Integer> list = new ArrayList<>();
    private static int[] findMode(TreeNode root) {
        inorder(root);
        int[] result = new int[list.size()];
        for (int i=0;i<list.size();i++) {
            result[i] = list.get(i);
        }
        return result;
    }
    /**
     * 先序遍历BST的结果是 升序的序列
     * @param root
     */
    public static void inorder(TreeNode root){
        if(null == root) {
            return;
        }
        inorder(root.left);
        if(preNum == null) {
            preNum = root.val;
            curTime = 1;
            list.add(root.val);
            maxTime = curTime;
        } else {
            if(preNum == root.val) {
                curTime++;
            }else {
                preNum = root.val;
                curTime = 1;
            }
            if(curTime == maxTime) {
                list.add(preNum);
            } else if(curTime>maxTime) {
                maxTime = curTime;
                list.clear();
                list.add(preNum);
            }
        }
        inorder(root.right);
    }
}
