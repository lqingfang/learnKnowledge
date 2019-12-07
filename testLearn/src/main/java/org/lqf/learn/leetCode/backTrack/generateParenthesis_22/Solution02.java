package org.lqf.learn.leetCode.backTrack.generateParenthesis_22;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution02 {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(generateParenthesis(n));
    }
    static class Node{
        int left;
        int right;
        String res;

        public Node(int left, int right, String res) {
            this.left = left;
            this.right = right;
            this.res = res;
        }
    }
    public static List<String> generateParenthesis(int n) {
        Queue queue = new LinkedList();
        queue.offer(new Node(n,n,""));
        int size = n*2;
        while (size>0) {
            int qSize = queue.size();
            for(int i=0;i<qSize;i++) {
                Node node = (Node)queue.poll();
                if(node.left>0) {
                    queue.offer(new Node(node.left-1,node.right,node.res+"("));
                }
                if(node.right >0 && node.right > node.left) {
                    queue.offer(new Node(node.left,node.right-1,node.res+")"));
                }
            }
            size--;
        }
        List<String> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            Node node = (Node)queue.poll();
            res.add(node.res);
        }

        return res;
    }

}
