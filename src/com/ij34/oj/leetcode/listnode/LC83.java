package com.ij34.oj.leetcode.listnode;

/**
 * 83. 删除排序链表中的重复元素
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-list
 *
 * @Author: ij34
 * @Date: 2024-06-25
 */

public class LC83 {
    public ListNode deleteDuplicates(ListNode head) {
       if (head==null || head.next==null){
           return head;
       }
       int cur= head.val;
       while (head!=null && head.val==cur){
           head=head.next;
       }
       ListNode p =new ListNode(cur);
       p.next=deleteDuplicates(head);
       return p;
    }

}
