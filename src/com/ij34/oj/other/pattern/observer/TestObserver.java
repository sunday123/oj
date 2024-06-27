package com.ij34.oj.other.pattern.observer;

import com.ij34.oj.other.pattern.observer.impl.ObserverImpl;
import com.ij34.oj.other.pattern.observer.impl.SubjectImpl;

/**
 * @Author: ij34
 * @Date: 2024-06-27
 */

public class TestObserver {
    public static void main(String[] args) {
        Observer a = new ObserverImpl("a");
        Observer b = new ObserverImpl("b");
        Subject s = new SubjectImpl();
        s.add(a);
        s.add(b);
        s.update(1000);
    }
}
