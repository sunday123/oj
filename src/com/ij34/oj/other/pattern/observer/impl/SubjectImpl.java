package com.ij34.oj.other.pattern.observer.impl;

import com.ij34.oj.other.pattern.observer.Observer;
import com.ij34.oj.other.pattern.observer.Subject;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ij34
 * @Date: 2024-06-27
 */

public class SubjectImpl implements Subject {
    private List<Observer> list = new ArrayList<>();
    private int state;
    @Override
    public void add(Observer o) {
        list.add(o);
    }


    @Override
    public void update(int state) {
        this.state=state;
        notifyAllObserver();
    }

    @Override
    public void notifyAllObserver() {
        for (Observer observer : list){
            observer.received(state);
        }
    }
}
