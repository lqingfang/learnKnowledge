package org.lqf.learn.leetCode.binaryTree.rob_337;

import org.lqf.learn.leetCode.binaryTree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * dfs 优化
 */
public class Solution02 {
    public static void main(String[] args) {

    }
    public int rob(TreeNode root) {
        Map<TreeNode,Integer> map = new HashMap<>();
        return dfs(root,map);
    }

    private int dfs(TreeNode root, Map<TreeNode, Integer> map) {
        if(null == root) {
            return 0;
        }
        if(null != map.get(root)) {
            return map.get(root);
        }
        int value = root.val;
        if(null != root.left) {
            value += dfs(root.left.left,map) + dfs(root.left.right,map);
        }
        if(null != root.right) {
            value += dfs(root.right.left,map) + dfs(root.right.right,map);
        }
        int max = Math.max(value,dfs(root.left,map) +dfs(root.right,map));
        map.put(root,max);
        return max;
    }
}
