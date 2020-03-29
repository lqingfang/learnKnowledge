package org.lqf.learn.leetCode.linkedList.hasCycle_141;

import org.lqf.learn.leetCode.linkedList.ListNode;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if(set.contains(head)) {
                return true;
            }else {
                set.add(head);
                head = head.next;
            }
        }
        return false;
    }
}
