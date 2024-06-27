package com.ij34.oj.other;

import java.util.ArrayDeque;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 自定义阻塞队列
 * @Author: ij34
 * @Date: 2024-06-27
 */

public class CustomBlockingQueueExample {
    static class CustomBlockingQueue {
        ArrayDeque<Integer> deque;
        private int cap;


        public CustomBlockingQueue(int cap) {
            deque = new ArrayDeque();
            this.cap = cap;
        }

        private synchronized void push(int val) throws InterruptedException {


            while (deque.size() == cap){
               wait();
            }
            deque.offerLast(val);
            notifyAll();

        }

        private synchronized int poll() throws InterruptedException {

            while (deque.isEmpty()){
                 wait();
            }

            int poll= deque.removeFirst();
            notifyAll();
            return poll;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        CustomBlockingQueue queue = new CustomBlockingQueue(2);
        new Thread(()->{

            for (int i=1;i<=10;i++){
                try {
                    queue.push(i);
                    System.out.println("add:"+i);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        }).start();

        new Thread(()->{
            for (int i=1;i<=10;i++){
                try {
                    System.out.println(i+":"+ queue.poll());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();



    }

}
