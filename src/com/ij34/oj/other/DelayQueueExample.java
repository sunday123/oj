package com.ij34.oj.other;

import java.util.Date;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * 实现延迟队列
 * @Author: ij34
 * @Date: 2024-06-27
 */

public class DelayQueueExample {

    static class Message implements Delayed {
        private  String msg;
        private  long delay;//毫秒
        private  long expire;

        public Message(String msg, long delay) {
            this.msg = msg;
            this.delay = delay;
            this.expire=System.nanoTime()+ TimeUnit.MILLISECONDS.toNanos(delay);
        }

        @Override
        public long getDelay(TimeUnit unit) {
            return unit.convert(this.expire-System.nanoTime(),TimeUnit.NANOSECONDS);
        }

        @Override
        public int compareTo(Delayed o) {
            long a= this.getDelay(TimeUnit.NANOSECONDS)-o.getDelay(TimeUnit.NANOSECONDS);
            if (a>0){
                return 1;
            }
            if (a==0){
                return 0;
            }
            return -1;
        }
    }
    public static void main(String[] args) throws InterruptedException {
        Message a =new Message("a",2000);
        Message b =new Message("b",3000);
        Message c =new Message("c",5000);
        DelayQueue<Message> delayQueue = new DelayQueue<>();
        delayQueue.add(a);
        delayQueue.add(b);
        delayQueue.add(c);
        while (delayQueue.isEmpty()==false){
            Message take = delayQueue.take();
            System.out.println(new Date()+"="+take.msg);

        }
    }
}