package org.lqf.learn.leetCode.binaryTree.codec_297;

import org.lqf.learn.leetCode.binaryTree.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Codec {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        root.left = node2;
        root.right = node3;
        node3.left = node4;
        node3.right = node5;
        //System.out.println(serialize(root));
        //String data = "[1,2,null,null,3,4,null,null,5,null,null]";
        String data = "[]";
        deserialize(data);
    }
    public static String serialize(TreeNode root) {
        if(null == root) {
            return "[]";
        }
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<String> resQueue = new LinkedList<>();
        queue.add(root);
        resQueue.add(String.valueOf(root.val));
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if(null != node.left) {
                queue.add(node.left);
                resQueue.add(String.valueOf(node.left.val));
            }else {
                resQueue.add("null");
            }

            if(null != node.right) {
                queue.add(node.right);
                resQueue.add(String.valueOf(node.right.val));
            }else {
                resQueue.add("null");
            }
        }
        StringBuilder res = new StringBuilder();
        res.append("[");
        while (!resQueue.isEmpty()) {
            String node = resQueue.poll();
            res.append(node);
            if(!resQueue.isEmpty()) {
                res.append(",");
            }
        }
        res.append("]");
        return res.toString();
    }


    public static TreeNode deserialize(String data) {
        if(data.length() == 0) {
            return null;
        }
        String str = data.substring(1,data.length()-1);
        if(str.length() == 0) {
            return null;
        }
        Queue<String> dataQueue = new LinkedList<>(Arrays.asList(str.split(",")));
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = null;
        while (!dataQueue.isEmpty()) {
            String nodeValue = dataQueue.poll();
            if(root == null) {
                root = new TreeNode(Integer.parseInt(nodeValue));
                queue.add(root);
                continue;
            }
            TreeNode fatherNode = queue.poll();
            if(!nodeValue.equals("null")) {
                TreeNode node = new TreeNode(Integer.parseInt(nodeValue));
                fatherNode.left = node;
                queue.add(node);
            }
            nodeValue = dataQueue.poll();
            if(!nodeValue.equals("null")) {
                TreeNode node = new TreeNode(Integer.parseInt(nodeValue));
                fatherNode.right = node;
                queue.add(node);
            }
        }
        return root;
    }
}