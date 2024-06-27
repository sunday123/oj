package com.ij34.oj.other.pattern.proxy.impl;

import com.ij34.oj.other.pattern.proxy.IImage;

/**
 * @Author: ij34
 * @Date: 2024-06-27
 */

public class ImageProxyImpl implements IImage {

    private ImageImpl image;

    public ImageProxyImpl() {
        image = new ImageImpl();
    }

    @Override
    public void request() {
        System.out.println("代理前");
        image.request();
        System.out.println("代理后");

    }
}
