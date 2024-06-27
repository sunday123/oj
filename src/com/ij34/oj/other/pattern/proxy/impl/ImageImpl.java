package com.ij34.oj.other.pattern.proxy.impl;

import com.ij34.oj.other.pattern.proxy.IImage;

/**
 * @Author: ij34
 * @Date: 2024-06-27
 */

public class ImageImpl implements IImage {
    @Override
    public void request() {
        System.out.println("request123");
    }
}
