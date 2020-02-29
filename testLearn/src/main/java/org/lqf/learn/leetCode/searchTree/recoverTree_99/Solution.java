package org.lqf.learn.leetCode.searchTree.recoverTree_99;

import org.lqf.learn.leetCode.searchTree.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {

    }
    List<Integer> list;
    public void recoverTree(TreeNode root) {
        if(null == root) {
            return;
        }
        list = new ArrayList<>();
        dfs(root);
        int x=-1,y=-1;
        for(int i=0;i<list.size()-1;i++) {
            if(list.get(i) > list.get(i+1)) {
                y = list.get(i+1);
                if(x != -1) {
                    break;
                }
                x = list.get(i);
            }
        }
        reDfs(root,x,y);
    }

    private void reDfs(TreeNode root, int x, int y) {
        if(null == root) {
            return;
        }
        if(root.val == x || root.val == y) {
            if(root.val == x) {
                root.val = y;
            }else {
                root.val = x;
            }
        }
        reDfs(root.left,x,y);
        reDfs(root.right,x,y);
    }

    public void dfs(TreeNode node) {
        if(null == node) {
            return;
        }
        dfs(node.left);
        list.add(node.val);
        dfs(node.right);
    }
}
