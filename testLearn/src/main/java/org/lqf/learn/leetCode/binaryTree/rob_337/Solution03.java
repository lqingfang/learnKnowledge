package org.lqf.learn.leetCode.binaryTree.rob_337;

import org.lqf.learn.leetCode.binaryTree.TreeNode;

/**
 * dp
 * 每个节点可选择偷或者不偷两种状态，根据题目意思，相连节点不能一起偷
 *
 * 当前节点选择偷时，那么两个孩子节点就不能选择偷了
 * 当前节点选择不偷时，两个孩子节点只需要拿最多的钱出来就行(两个孩子节点偷不偷没关系)
 * 我们使用一个大小为2的数组来表示 int[] res = new int[2] 0代表不偷，1代表偷
 * 任何一个节点能偷到的最大钱的状态可以定义为
 *
 * 当前节点选择不偷: 当前节点能偷到的最大钱数 = 左孩子能偷到的钱 + 右孩子能偷到的钱
 * 当前节点选择偷: 当前节点能偷到的最大钱数 = 左孩子选择自己不偷时能得到的钱 + 右孩子选择不偷时能得到的钱 + 当前节点的钱数
 * 表示为公式如下
 *
 * root[0] = Math.max(rob(root.left)[0], rob(root.left)[1]) + Math.max(rob(root.right)[0], rob(root.right)[1])
 * root[1] = rob(root.left)[0] + rob(root.right)[0] + root.val;
 */
public class Solution03 {
    public static void main(String[] args) {

    }
    public int rob(TreeNode root) {
        int[] res = dfs(root);
        return Math.max(res[0],res[1]);
    }

    private int[] dfs(TreeNode root) {
        if(null == root) {
            return new int[2];
        }
        int[] res = new int[2];

        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        res[0] = Math.max(left[0],left[1])+Math.max(right[0],right[1]);
        res[1] = left[0]+right[0]+root.val;
        return res;
    }
}
