package org.lqf.learn.leetCode.binarySearch.preorder_589;

import org.lqf.learn.leetCode.binaryTree.Node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * dfs
 */
public class Solution {
    public List<Integer> preorder(Node root) {
        if(null == root) {
            return Collections.emptyList();
        }
        List<Integer> res = new ArrayList<>();
        dfs(root,res);
        return res;
    }

    private void dfs(Node root, List<Integer> res) {
        if(null == root) {
            return;
        }
        res.add(root.val);
        int child = root.children.size();
        for(int i=0;i<child;i++) {
            dfs(root.children.get(i),res);
        }
    }
}
