package org.lqf.learn.leetCode.binarySearch.postorder_590;

import org.lqf.learn.leetCode.binaryTree.Node;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        dfs(root,res);
        return res;
    }
    private void dfs(Node root, List<Integer> res) {
        if(null == root) {
            return;
        }
        for(Node cur:root.children) {
            dfs(cur,res);
        }
        res.add(root.val);
    }
}
