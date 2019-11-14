package org.lqf.learn.leetCode.bfsAndDfs.cloneGraph_133;

import org.lqf.learn.leetCode.bfsAndDfs.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    Map<Node,Node> cloneNodes = new HashMap<>();
    public Node cloneGraph(Node node) {
        Node cloneNode = cloneNodes.get(node);
        if(null != cloneNode) {
            return cloneNode;
        }
        cloneNode = new Node(node.val,new ArrayList<>());
        cloneNodes.put(node,cloneNode);
        for(Node neighbor:node.neighbors) {
            cloneNode.neighbors.add(cloneGraph(neighbor));
        }
        return cloneNode;
    }
}
