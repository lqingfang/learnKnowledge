package org.lqf.learn.leetCode.linkedList.partition_86;

import org.lqf.learn.leetCode.linkedList.ListNode;

public class Solution01 {
    public ListNode partition(ListNode head, int x) {
        if(null == head) {
            return head;
        }
        ListNode pre = new ListNode(0);
        ListNode curPre = pre;
        ListNode post = new ListNode(0);
        ListNode curPost = post;
        while (null != head) {
            if(head.val < x) {
                curPre.next = head;
                head = head.next;
                curPre = curPre.next;
                curPre.next = null;
            }else {
                curPost.next = head;
                head = head.next;
                curPost = curPost.next;
                curPost.next = null;
            }
        }
        curPre.next = post.next;
        return pre.next;
    }
}
