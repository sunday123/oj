package com.ij34.oj.other.pattern.observer;

import com.ij34.oj.other.pattern.observer.impl.SubjectImpl;

/**
 * @Author: ij34
 * @Date: 2024-06-27
 */

public interface Observer {

    void received(int state);
}
