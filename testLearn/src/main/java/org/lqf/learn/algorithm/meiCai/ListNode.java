package org.lqf.learn.algorithm.meiCai;

//删除链表中的指定值的元素
public class ListNode {
    int val;
    ListNode next;

    public ListNode(int v) {
        this.val = v;
    }
    public ListNode(int[] arr) throws IllegalAccessException {
        if(null== arr || arr.length==0) {
            throw new IllegalAccessException("arr can not be empty");
        }
        this.val = arr[0];
        ListNode listNode = this;
        for(int i=1;i<arr.length;i++) {
            listNode.next = new ListNode(arr[i]);
            listNode = listNode.next;
        }
    }
    public String toString() {
        StringBuilder res = new StringBuilder();
        ListNode listNode = this;
        while (null != listNode) {
            res.append(listNode.val+"->");
            listNode = listNode.next;
        }
        res.append("null");
        return res.toString();
    }
    public static ListNode removeIfElement(ListNode listNode,int x){
        if(null == listNode) {
            return listNode;
        }
        //头节点是该值的情况
        ListNode head = listNode;
        while (x == head.val) {
            head = head.next;
        }

        //此时一定保证头节点不是该值
        if (null != head) {
            ListNode pre = head;
            while (null !=pre.next){
                if(pre.next.val == x) {
                    pre.next = pre.next.next;
                }
                pre = pre.next;

            }
        }
        return head;
    }

    public static void main(String[] args) throws IllegalAccessException {
        int[] nums = {2,2,4,5,6,2,1};
        ListNode listNode = new ListNode(nums);
        System.out.println(listNode);
        ListNode listNode1 = removeIfElement(listNode,2);
        System.out.println(listNode1);
    }

}
