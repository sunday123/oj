package com.ij34.oj.leetcode.listnode;

import com.ij34.oj.leetcode.listnode.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 234. 回文链表
 * https://leetcode.cn/problems/palindrome-linked-list/description/?envType=study-plan-v2&envId=top-100-liked
 * @Author: ij34
 * @Date: 2024-05-10
 */

public class PalindromeListNodeOj {
    public boolean isPalindrome(ListNode head) {
       List<Integer> list= new ArrayList<>();
       while (head!=null){
           list.add(head.val);
           head=head.next;
       }
       int len =list.size();
       for (int i=0;i<len/2;i++){
           if (list.get(i)!=list.get(len-i-1)){
               return false;
           }
       }
       return true;
    }
}
