package com.ij34.oj.other.pattern.observer.impl;

import com.ij34.oj.other.pattern.observer.Observer;

/**
 * @Author: ij34
 * @Date: 2024-06-27
 */

public class ObserverImpl implements Observer {
    private String name;

    private int state;

    public ObserverImpl(String name) {
        this.name = name;
    }

    @Override
    public void received(int newState) {
       state=newState;
        System.out.println(name+":received:"+state);
    }
}
