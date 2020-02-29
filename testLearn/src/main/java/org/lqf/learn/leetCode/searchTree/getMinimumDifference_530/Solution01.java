package org.lqf.learn.leetCode.searchTree.getMinimumDifference_530;

import org.lqf.learn.leetCode.searchTree.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * dfs 存储
 */
public class Solution01 {
    public static void main(String[] args) {

    }
    static List<TreeNode> list;
    public int getMinimumDifference(TreeNode root) {
        list = new ArrayList<>();
        dfs(root);
        int min = Integer.MAX_VALUE;
        for(int i=0;i<list.size()-1;i++) {
            min = Math.min(list.get(i+1).val - list.get(i).val,min);
        }
        return min;
    }
    public void dfs(TreeNode root) {
        if(null == root) {
            return;
        }
        dfs(root.left);
        list.add(root);
        dfs(root.right);
    }
}
