package org.lqf.learn.leetCode.binaryTree.rob_337;

import org.lqf.learn.leetCode.binaryTree.TreeNode;

/**
 * dfs
 * 在解法1和解法2中 我们使用爷爷-两个孩子-4个孙子来说明问题
 * 首先来定义这个问题的状态
 * 爷爷节点获取到最大的偷取的钱数呢
 *
 * 首先要明确相邻的节点不能偷，也就是爷爷选择偷，儿子就不能偷了，但是孙子可以偷
 * 二叉树只有左右两个孩子，一个爷爷最多2个儿子,4个孙子
 * 根据以上条件，我们可以得出单个节点的钱该怎么算
 * ** 4个孙子偷的钱 + 爷爷的钱 VS 两个儿子偷的钱 哪个组合钱多，就当做当前节点能偷的最大钱数。这就是动态规划里面的最优子结构**
 *
 */
public class Solution01 {
    public static void main(String[] args) {

    }
    public int rob(TreeNode root) {
        if(null == root) {
            return 0;
        }
        int value = root.val;
        if(null != root.left) {
            value += rob(root.left.left) + rob(root.left.right);
        }
        if(null != root.right) {
            value += rob(root.right.left) + rob(root.right.right);
        }
        return Math.max(value,rob(root.left) +rob(root.right));

    }
}
