package com.ij34.oj.other.pattern.proxy;

import com.ij34.oj.other.pattern.proxy.impl.ImageProxyImpl;

/**
 * @Author: ij34
 * @Date: 2024-06-28
 */

public class TestProxy {

    public static void main(String[] args) {
        IImage a = new ImageProxyImpl();
        a.request();
    }
}
