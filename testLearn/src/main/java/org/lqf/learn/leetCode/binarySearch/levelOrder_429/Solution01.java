package org.lqf.learn.leetCode.binarySearch.levelOrder_429;

import org.lqf.learn.leetCode.binaryTree.Node;

import java.util.*;

public class Solution01 {
    public List<List<Integer>> levelOrder(Node root) {
        if(null == root) {
            return Collections.emptyList();
        }
        List<List<Integer>> res = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for(int i =0;i<size;i++) {
                Node node = queue.poll();
                list.add(node.val);
                for(Node child : node.children) {
                    queue.add(child);
                }
            }
            res.add(list);
        }
        return res;
    }
}
