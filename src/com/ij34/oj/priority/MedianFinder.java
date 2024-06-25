package com.ij34.oj.priority;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 295. 数据流的中位数
 * https://leetcode.cn/problems/find-median-from-data-stream
 *
 * @Author: ij34
 * @Date: 2024-06-25
 */

public class MedianFinder {
    PriorityQueue<Integer> minQueue,maxQueue;

    public MedianFinder() {
        minQueue= new PriorityQueue<>((o1, o2) -> o2-o1);//3 2 1大到小
        maxQueue=new PriorityQueue<>((o1, o2) -> o1-o2);//4 5 6小到大
    }

    public void addNum(int num) {
         if (minQueue.isEmpty() || minQueue.size()<=maxQueue.size()){
             minQueue.offer(num);
             if (maxQueue.isEmpty()==false && minQueue.peek()>maxQueue.peek()){
                 int a=minQueue.poll();//5 1
                 int b=maxQueue.poll();//3 4
                 minQueue.offer(b);
                 maxQueue.offer(a);

             }
         }else {
             maxQueue.offer(num);
             if (minQueue.peek()>maxQueue.peek()){
                 int a=minQueue.poll();//5 1
                 int b=maxQueue.poll();//3 4
                 minQueue.offer(b);
                 maxQueue.offer(a);
             }
         }
    }

    public double findMedian() {
        if (minQueue.size()==maxQueue.size()){
            return (0.0+maxQueue.peek()+minQueue.peek())/2;
        }
        return minQueue.peek();

    }
}
