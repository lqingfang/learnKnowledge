package org.lqf.learn.leetCode.binaryTree.serialize_297;

import org.lqf.learn.leetCode.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Codec {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(8);
        TreeNode node3 = new TreeNode(11);
        TreeNode node4 = new TreeNode(13);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(7);
        TreeNode node7 = new TreeNode(2);
        TreeNode node8 = new TreeNode(1);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node5.right = node8;
        //System.out.println(Serialize(root));
        String s = "[5,4,11,7,null,2,null]";
        TreeNode treeNode = deserialize(s);
        System.out.println(Serialize(treeNode));
        //System.out.println(treeNode.val);
    }

    static List<String> list = new ArrayList<String>();
    public static String Serialize(TreeNode root) {
        getSerializeList(root);
        return list.toString();
    }

    private static void getSerializeList(TreeNode root) {
        if(null == root) {
            list.add("null");
        }else {
            list.add(root.val+"");
        }
        if(null != root.left) {
            getSerializeList(root.left);
        }else {
            list.add("null");
        }
        if(null != root.right) {
            getSerializeList(root.right);
        }else {
            list.add("null");
        }
    }

    public static TreeNode deserialize(String data) {
        data = data.substring(1, data.length()-1);
        String[] treeStr = data.split(",");
        List<String> treeList = new LinkedList<>(Arrays.asList(treeStr));
        TreeNode root = getTreeNode(treeList);
        return root;
    }

    private static TreeNode getTreeNode(List<String> treeList) {
        if (treeList.size() <1) {
            return null;
        }
        if (treeList.get(0) .equals("null") ) {
            treeList.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(treeList.get(0).trim()));
        treeList.remove(0);
        root.left = getTreeNode(treeList);
        root.right = getTreeNode(treeList);
        return root;
    }
}
