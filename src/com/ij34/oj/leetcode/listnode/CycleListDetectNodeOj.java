package com.ij34.oj.leetcode.listnode;

import com.ij34.oj.leetcode.listnode.ListNode;

/**
 * 142. 环形链表 II
 * @Author: ij34
 * @Date: 2024-05-10
 */

public class CycleListDetectNodeOj {
    public ListNode detectCycle(ListNode head) {
        if (head==null || head.next==null){
            return null;
        }
        ListNode slow =head,fast =head;
        while (fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if (slow==fast){
                break;
            }
        }
        if (fast==null || fast.next==null){
           return null;
        }
        slow=head;
        while (fast!=slow){
            slow=slow.next;
            fast=fast.next;
        }
        return slow;
    }
}
