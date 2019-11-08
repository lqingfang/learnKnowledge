package org.lqf.learn.leetCode.binaryTree;

import java.util.ArrayList;
import java.util.List;

public class Node {
    public int val;
    public List<Node> children = new ArrayList<>();

    public Node(int val) {
        this.val = val;
    }
}
