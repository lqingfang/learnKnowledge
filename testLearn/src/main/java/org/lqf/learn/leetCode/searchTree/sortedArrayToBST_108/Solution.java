package org.lqf.learn.leetCode.searchTree.sortedArrayToBST_108;

import org.lqf.learn.leetCode.binaryTree.TreeNode;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {};
        sortedArrayToBST(nums);
    }

    private static TreeNode sortedArrayToBST(int[] nums) {
        return toBST(nums,0,nums.length-1);
    }

    private static TreeNode toBST(int[] nums, int left, int right) {
        if(left > right) {
            return null;
        }
        int mid = (left+right)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = toBST(nums,left,mid-1);
        root.right = toBST(nums,mid+1,right);
        return root;
    }
}
