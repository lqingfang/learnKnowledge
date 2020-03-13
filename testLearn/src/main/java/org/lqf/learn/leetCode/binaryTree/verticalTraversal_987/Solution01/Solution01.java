package org.lqf.learn.leetCode.binaryTree.verticalTraversal_987.Solution01;

import org.lqf.learn.leetCode.binaryTree.TreeNode;
import java.util.*;

public class Solution01 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);
        root.left = node1;
        root.right = node2;
        node2.left = node3;
        node2.right = node4;
        System.out.println(verticalTraversal(root));
    }
    public static List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Comparator<State> comparator = new Comparator<State>() {
            @Override
            public int compare(State o1, State o2) {
                if(o1.position == o2.position) {
                    if(o1.level== o2.level) {
                        return o1.node.val - o2.node.val;
                    }else {
                        return o2.level-o1.level;
                    }
                }else {
                    return o1.position - o2.position;
                }
            }
        };

        /**
         * priQueue存的是排序好的
         */
        Queue<State> priQueue = new PriorityQueue<State>(comparator);
        Queue<State> queue = new LinkedList<>();
        queue.add(new State(root,1000,1));
        while (!queue.isEmpty()) {
            State state = queue.poll();
            priQueue.add(state);
            if(null != state.node.left) {
                queue.add(new State(state.node.left,state.position-1,state.level-1));
            }
            if(null != state.node.right) {
                queue.add(new State(state.node.right,state.position+1,state.level-1));
            }
        }
        int prePosition = -1;
        List<Integer> tmp = new ArrayList<>();
        while (!priQueue.isEmpty()) {
            State state = priQueue.poll();
            if(state.position==prePosition) {
                tmp.add(state.node.val);
            }else {
                if(tmp.size()>0) {
                    res.add(tmp);
                }
                tmp = new ArrayList<>();
                tmp.add(state.node.val);
                prePosition = state.position;
            }
        }
        if(tmp.size()>0) {
            res.add(tmp);
        }
        return res;
    }
}
