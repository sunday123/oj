package com.ij34.oj.leetcode.listnode;

import java.util.HashMap;
import java.util.Map;

/**
 * 138. 随机链表的复制
 * https://leetcode.cn/problems/copy-list-with-random-pointer
 * @Author: ij34
 * @Date: 2024-05-25
 */

public class CopyListWithRandomPointer {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        if (head==null){
            return null;
        }


        Map<Node,Node> map = new HashMap<>();
        Node head2 = head;
        while (head!=null){
            map.put(head,new Node(head.val));
            head=head.next;
        }
        head=head2;
        while (head2!=null){
            map.get(head2).next=map.get(head2.next);
            if (head2.random!=null){
                map.get(head2).random=map.get(head2.random);
            }
            head2=head2.next;
        }
        return map.get(head);
    }
}
