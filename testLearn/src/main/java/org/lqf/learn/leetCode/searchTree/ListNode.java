package org.lqf.learn.leetCode.searchTree;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
    public void print(ListNode listNode){
        while (null != listNode.next) {
            System.out.print(listNode.val +"->");
            listNode = listNode.next;
        }
        System.out.println(listNode.val);
    }
}
