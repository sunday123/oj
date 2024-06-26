package com.ij34.oj.leetcode.listnode;

/**
 * 23. 合并 K 个升序链表
 * https://leetcode.cn/problems/merge-k-sorted-lists
 *
 * @Author: ij34
 * @Date: 2024-06-26
 */

public class LC23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length<1){
            return null;
        }
        int minIndex=0,min=Integer.MAX_VALUE,nullCount=0;
        for (int i=0;i<lists.length;i++){
            if (lists[i]==null){
                nullCount++;
                continue;
            }
            if (lists[i].val<min){
                min=lists[i].val;
                minIndex=i;
            }
        }
        if (nullCount==lists.length){
            return null;
        }
        ListNode node = new ListNode(min);
        lists[minIndex]=lists[minIndex].next;
        node.next=mergeKLists(lists);
        return node;




    }

}
