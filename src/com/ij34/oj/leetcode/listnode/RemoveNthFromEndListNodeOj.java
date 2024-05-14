package com.ij34.oj.leetcode.listnode;

import com.ij34.oj.leetcode.listnode.ListNode;

/**
 * 19. 删除链表的倒数第 N 个结点
 * @Author: ij34
 * @Date: 2024-05-10
 */

public class RemoveNthFromEndListNodeOj {
    public ListNode removeNthFromEnd(ListNode head, int n) {
         ListNode p=head;
         int len=0;
         while (p!=null){
             len++;
             p=p.next;
         }
         n=len-n;
         if (n==0){
             return head.next;
         }
         ListNode pre=head,h=pre;
         while (n>1){
             n--;
             pre=pre.next;
         }
         if (pre.next.next!=null){
             pre.next=pre.next.next;
         }else {
             pre.next=null;
         }


         return h;






    }
}
