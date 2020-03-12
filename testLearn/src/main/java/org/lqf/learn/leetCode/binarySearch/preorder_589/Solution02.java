package org.lqf.learn.leetCode.binarySearch.preorder_589;

import org.lqf.learn.leetCode.binaryTree.Node;

import java.util.*;

/**
 * bfs
 */
public class Solution02 {
    public List<Integer> preorder(Node root) {
        if(null == root) {
            return Collections.emptyList();
        }
        List<Integer> res = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            res.add(node.val);
            Collections.reverse(node.children);
            for(Node cur:node.children) {
                stack.push(cur);
            }
        }
        return res;
    }
}
