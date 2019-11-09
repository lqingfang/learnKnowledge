package org.lqf.learn.leetCode.binaryTree;

/*
687 有点意思
124 不是很理解
508 不知道什么意思
337 题意不明白，好像是动态规划，后续再看
112 有点脑筋急转弯的感觉 没整出来
297  二叉树的序列化，反序列化，自测过了，leecode提交不过，不知道为什么
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
