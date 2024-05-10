package com.ij34.oj.leetcode;

/**
 * 141. 环形链表
 * https://leetcode.cn/problems/linked-list-cycle/description/?envType=study-plan-v2&envId=top-100-liked
 * @Author: ij34
 * @Date: 2024-05-10
 */

public class CycleListNodeOj {
    public boolean hasCycle(ListNode head) {
        if (head==null || head.next==null){
            return false;
        }
        ListNode slow =head,fast =head.next;
        while (fast!=null && fast.next!=null && fast.next.next!=null && slow!=fast){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow==fast;
    }
}
