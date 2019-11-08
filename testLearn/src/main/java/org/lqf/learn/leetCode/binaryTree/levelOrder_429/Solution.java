package org.lqf.learn.leetCode.binaryTree.levelOrder_429;

import org.lqf.learn.leetCode.binaryTree.Node;

import java.util.*;

public class Solution {
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
        List<List<Integer>> list = levelOrder(root);
        System.out.println(list);
    }



    private static List<List<Integer>> levelOrder(Node root) {
        if(null == root) {
            return Collections.emptyList();
        }
        List<List<Integer>> list = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            List<Integer> list0 = new ArrayList<>();
            int length = queue.size();
            for(int i= 0;i<length;i++){
                Node node = queue.poll();
                list0.add(node.val);
                for (int j=0;j<node.children.size();j++) {
                    queue.add(node.children.get(j));
                }
            }
            list.add(list0);
        }
        return list;
    }
}
