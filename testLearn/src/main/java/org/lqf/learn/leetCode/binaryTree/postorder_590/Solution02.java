package org.lqf.learn.leetCode.binaryTree.postorder_590;

import org.lqf.learn.leetCode.binaryTree.Node;

import java.util.*;

public class Solution02 {
    public static void main(String[] args) {
        Node root = new Node(1);
        Node node3 = new Node(3);
        Node node2 = new Node(2);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        root.children.add(node3);
        root.children.add(node2);
        root.children.add(node4);

        node3.children.add(node5);
        node3.children.add(node6);
        List<Integer> list = postorder(root);
        System.out.println(list);
    }

    private static List<Integer> postorder(Node root) {
        if(null == root) {
            return Collections.emptyList();
        }
        LinkedList<Integer> list = new LinkedList<>();
        Stack<Node> stack = new Stack<>();
        stack.add(root);

        while (!stack.isEmpty()) {
            Node node = stack.pop();
            list.addFirst(node.val);
            for(int i= 0;i<node.children.size();i++){
                stack.push(node.children.get(i));
            }
        }
        return list;
    }
}
