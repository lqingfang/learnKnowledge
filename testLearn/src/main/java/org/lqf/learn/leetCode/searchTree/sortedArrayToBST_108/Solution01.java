package org.lqf.learn.leetCode.searchTree.sortedArrayToBST_108;

import org.lqf.learn.leetCode.searchTree.TreeNode;

public class Solution01 {
    public static void main(String[] args) {

    }
    public TreeNode sortedArrayToBST(int[] nums) {
        int length = nums.length;
        TreeNode root = dfs(nums,0,length-1);
        return root;
    }

    private TreeNode dfs(int[] nums, int left, int right) {
        if(left > right) {
            return null;
        }
        int mid = (right+left)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = dfs(nums,left,mid-1);
        root.right = dfs(nums,mid+1,right);
        return root;
    }
}
