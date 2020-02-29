package org.lqf.learn.leetCode.searchTree.findTarget_653;

import org.lqf.learn.leetCode.searchTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution01 {
    public static void main(String[] args) {

    }
    List<TreeNode> list;
    public boolean findTarget(TreeNode root, int k) {
        if(null == root) {
            return false;
        }
        list = new ArrayList<>();
        dfs(root);
        int i=0,j = list.size()-1;
        while (i<j) {
            if((list.get(i).val + list.get(j).val )>k){
                j--;
            }else if((list.get(i).val + list.get(j).val ) < k){
                i++;
            }else {
                return true;
            }
        }
        return false;
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
