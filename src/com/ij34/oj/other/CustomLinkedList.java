package com.ij34.oj.other;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @Author: ij34
 * @Date: 2024-06-27
 */

public class CustomLinkedList extends ArrayList<Integer> {

    public Integer getFirst() {
        return super.get(0);
    }

    public Integer getLast() {
        return super.get(size()-1);
    }

    public Integer removeFirst() {
        return super.remove(0);
    }

    public Integer removeLast() {
        return super.remove(size()-1);
    }

    public void addFirst(Integer val) {
        super.add(0);
        for (int i=super.size()-1;i>0;i--){
            super.set(i,super.get(i-1));
        }
        super.set(0,val);
    }

    public void addLast(Integer integer) {
        super.add(integer);
    }



    public static void main(String[] args) {
        CustomLinkedList list = new CustomLinkedList();
        list.addFirst(1);
        list.addFirst(2);
        System.out.println(list.removeFirst());
    }
}
