package com.ij34.oj.leetcode.listnode;

import com.ij34.oj.leetcode.listnode.ListNode;

/**
 * 21. 合并两个有序链表
 * @Author: ij34
 * @Date: 2024-05-10
 */

public class MergeTwoListNodeOj {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list2==null){
            return list1;
        }
        if (list1==null){
            return list2;
        }
        if (list1.val< list2.val){
            ListNode listNode  = new ListNode(list1.val);
            listNode.next=mergeTwoLists(list1.next,list2);
            return listNode;
        }else {
            ListNode listNode  = new ListNode(list2.val);
            listNode.next=mergeTwoLists(list1,list2.next);
            return listNode;
        }

    }
}
