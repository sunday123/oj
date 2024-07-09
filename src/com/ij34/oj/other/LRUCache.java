package com.ij34.oj.other;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.DelayQueue;

/**
 * LRU缓存
 * @Author: ij34
 * @Date: 2024-06-27
 */

public class LRUCache  extends LinkedHashMap<Integer,Integer> {
    private int cap;

    public LRUCache(int capacity) {
        super(capacity,0.75f,true);
        this.cap=capacity;
    }



    public int get(int key) {
        return super.getOrDefault(key,-1);
    }

    public void put(int key, int value) {
        super.put(key,value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return super.size()>cap;
    }
}