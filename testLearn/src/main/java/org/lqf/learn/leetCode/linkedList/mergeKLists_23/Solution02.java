package org.lqf.learn.leetCode.linkedList.mergeKLists_23;

import org.lqf.learn.leetCode.linkedList.ListNode;

public class Solution02 {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) {
            return null;
        }
        int size = lists.length;
        
        return solve(lists,0,size-1);
    }

    private ListNode solve(ListNode[] lists, int left, int right) {
        if(left == right) {
            return lists[left];
        }
        int mid = (left+right)>>1;
        ListNode leftNode = solve(lists,left,mid);
        ListNode rightNode = solve(lists,mid+1,right);
        return merge(lists,leftNode,rightNode);
    }

    private ListNode merge(ListNode[] lists, ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
                cur = cur.next;
            }else {
                cur.next = l2;
                l2 = l2.next;
                cur = cur.next;
            }
        }
        if(l1 != null) {
            cur.next = l1;
        }
        if(l2!=null) {
            cur.next = l2;
        }
        return dummy.next;
    }
}
