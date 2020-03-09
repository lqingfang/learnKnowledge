package org.lqf.learn.leetCode.binaryTree.findSecondMinimumValue_671;

import org.lqf.learn.leetCode.binaryTree.TreeNode;

public class Solution01 {
    public static void main(String[] args) {

    }
    public int findSecondMinimumValue(TreeNode root) {
        if(root == null ||(root.left == null && root.right == null)) {
            return -1;
        }
        int left = root.left.val;
        int right = root.right.val;
        //root一定是最小的，所以要不是左子树，要不是右子树
        //和root 相等的时候，再去算，
        // 否则不用算,因为不相等，则第二小，一定在  left,right中产生
        if(left == root.val) {
            left = findSecondMinimumValue(root.left);
        }
        if(right == root.val) {
            right = findSecondMinimumValue(root.right);
        }
        if(left != -1 && right != -1) {
            return Math.min(left,right);
        }
        if(left != -1) {
            return left;
        }
        return right;
    }
}
