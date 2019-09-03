package org.lqf.learn.algorithm;

public class ArrayToTreeGetDeep {
    public static void main(String[] args) {
        int[] arr = {3,4,2,7,8,1,0,9};
        TreeNode treeNode = turnToTree(arr,0);
        int deep = calcuDeep(treeNode);
        System.out.println(deep);
    }

    private static TreeNode turnToTree(int[] arr,int index) {
        TreeNode treeNode = null;
        if(index<arr.length){
            treeNode = new TreeNode(arr[index]);
            treeNode.left = turnToTree(arr,index*2+1);
            treeNode.right = turnToTree(arr,index*2+2);
        }
        return treeNode;
    }

    public static int calcuDeep(TreeNode treeNode){
        if(null == treeNode){
            return 0;
        }
        int left = calcuDeep(treeNode.left);
        int right = calcuDeep(treeNode.right);
        return left>right?(left+1):(right+1);
    }
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
