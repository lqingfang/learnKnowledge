package org.lqf.learn.leetCode.binarySearch.postorder_590;

import org.lqf.learn.leetCode.binaryTree.Node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Solution02 {
    public List<Integer> postorder(Node root) {
        if(null == root) {
            return Collections.emptyList();
        }
        List<Integer> res = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            Node node = stack.pop();
            res.add(0,node.val);
            for(Node child:node.children) {
                stack.push(child);
            }
        }
        return res;
    }
}
