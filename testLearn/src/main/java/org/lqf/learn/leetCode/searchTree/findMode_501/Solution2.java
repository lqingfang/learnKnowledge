package org.lqf.learn.leetCode.searchTree.findMode_501;

import org.lqf.learn.leetCode.searchTree.TreeNode;

import java.util.*;

public class Solution2 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node = new TreeNode(2);
        root.right = node;
        int[] res =findMode(root);
        System.out.println(Arrays.toString(res));
    }
    static Queue<TreeNode> queue;
    public static int[] findMode(TreeNode root) {
        int maxTimes = 0;
        int curTimes = 0;
        TreeNode pre = null;
        List<Integer> list = new ArrayList<>();
        queue = new LinkedList<>();
        dfs(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if(pre != null && pre.val == node.val) {
                curTimes++;
            }else {
                curTimes = 1;
            }
            if(maxTimes < curTimes) {
                maxTimes = curTimes;
                list.clear();
                list.add(node.val);
            }else if (maxTimes == curTimes){
                list.add(node.val);
            }
            pre = node;
        }
        int[] res = new int[list.size()];
        for(int i=0;i<list.size();i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public static void dfs(TreeNode root) {
        if(null == root) {
            return;
        }
        dfs(root.left);
        queue.add(root);
        dfs(root.right);
    }
}
