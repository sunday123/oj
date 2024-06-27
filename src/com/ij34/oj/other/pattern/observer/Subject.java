package com.ij34.oj.other.pattern.observer;

/**
 * @Author: ij34
 * @Date: 2024-06-27
 */

public interface Subject {
    void add(Observer o);
    void update(int state);
    void notifyAllObserver();
}
