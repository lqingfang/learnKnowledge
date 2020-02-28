package org.lqf.learn.leetCode.searchTree.findMode_501;

import org.lqf.learn.leetCode.searchTree.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * dfs
 */
public class Solution01 {
    public static void main(String[] args) {

    }
    static List<Integer> list;
    TreeNode preNode = null;
    int curTimes = 0;
    int maxTimes = 0;
    public int[] findMode(TreeNode root) {
        list = new ArrayList<>();
        dfs(root);
        int[] res = new int[list.size()];
        for(int i=0;i<list.size();i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private void dfs(TreeNode root) {
        if(root == null) {
            return;
        }
        dfs(root.left);
        if(preNode != null && root.val == preNode.val) {
            curTimes++;
        }else {
            curTimes = 1;
        }
        if(curTimes == maxTimes) {
          list.add(root.val);
        } else if(curTimes > maxTimes) {
            maxTimes = curTimes;
            list.clear();
            list.add(root.val);
        }
        preNode = root;
        dfs(root.right);
    }
}
