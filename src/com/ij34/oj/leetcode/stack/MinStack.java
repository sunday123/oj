package com.ij34.oj.leetcode.stack;

import java.util.ArrayDeque;
import java.util.LinkedList;

/**
 * 155. 最小栈
 * https://leetcode.cn/problems/min-stack
 * @Author: ij34
 * @Date: 2024-05-25
 */

public class MinStack {
    private LinkedList<Integer> list;
    public MinStack() {
        list =  new LinkedList<>();
    }

    public void push(int val) {
        list.addLast(val);
    }

    public void pop() {
         if (list.isEmpty()==false){
             list.removeLast();
         }
    }

    public int top() {
        return list.getLast();
    }

    public int getMin() {
        return list.stream().mapToInt(Integer::intValue).min().getAsInt();
    }


}
