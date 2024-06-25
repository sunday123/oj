package com.ij34.oj.leetcode.listnode;

/**
 *
 * 82. 删除排序链表中的重复元素 II
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-list-ii/
 *
 * @Author: ij34
 * @Date: 2024-06-25
 */

public class LC82 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head==null || head.next==null){
            return head;
        }
        int cur= head.val;
        int count=0;
        while (head!=null && head.val==cur){
            head=head.next;
            count++;
        }
        if (count==1){
            ListNode p =new ListNode(cur);
            p.next=deleteDuplicates(head);
            return p;
        }else {
            return deleteDuplicates(head);
        }

    }
}
