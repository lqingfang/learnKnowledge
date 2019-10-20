package org.lqf.learn.leetCode.linkedList.mergeKLists_23;

import org.lqf.learn.leetCode.linkedList.ListNode;


public class Solution {
    public static void main(String[] args) {
        ListNode[] lists = new ListNode[3];
        ListNode lA = new ListNode(1);
        lA.next = new ListNode(3);
        lists[0] = lA;

        ListNode lB = new ListNode(2);
        lB.next = new ListNode(3);
        lists[1] = lB;


        ListNode lC = new ListNode(1);
        lC.next = new ListNode(6);
        lists[2] = lC;

        ListNode listNode = mergeKLists(lists);
        listNode.print(listNode);
    }

    private static ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) {
            return null;
        }
        return solve(lists,0,lists.length-1);
    }

    private static ListNode solve(ListNode[] lists, int left, int right) {
        if(left == right) {
            return lists[left];
        }
        int mid = (left+right) >>1;
        ListNode lNode = solve(lists,left,mid);
        ListNode rNode = solve(lists,mid+1,right);
        return merge(lNode,rNode);
    }

    private static ListNode merge(ListNode lNode, ListNode rNode) {
        if(null == lNode) {
            return rNode;
        }
        if(null == rNode) {
            return lNode;
        }
        if(lNode.val < rNode.val) {
            lNode.next = merge(lNode.next,rNode);
            return lNode;
        }else {
            rNode.next = merge(rNode.next,lNode);
            return rNode;
        }
    }
}
