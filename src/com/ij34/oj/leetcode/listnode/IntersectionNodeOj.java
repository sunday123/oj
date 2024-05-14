package com.ij34.oj.leetcode.listnode;


import com.ij34.oj.leetcode.listnode.ListNode;

/**
 * 160. 相交链表
 * @Author: ij34
 * @Date: 2024-05-10
 */


public class IntersectionNodeOj {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA==null || headB==null){
            return null;
        }
        ListNode p =headA,q=headB;
        while (p!=q){
            p=p==null?headB:p.next;
            q=q==null?headA:q.next;
        }

        return p;

    }
}
