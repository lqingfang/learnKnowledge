package org.lqf.learn.leetCode.binaryTree;

public class State {
    public TreeNode node;
    public int position;
    public int level;

    public State(TreeNode node, int position, int level) {
        this.node = node;
        this.position = position;
        this.level = level;
    }
}
