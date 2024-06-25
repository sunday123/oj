package com.ij34.oj.leetcode.sub;

/**
 * 238. 除自身以外数组的乘积
 * https://leetcode.cn/problems/product-of-array-except-self
 * 1 2 3 4
 * 1 2 6 24
 * 24 24 12 4
 * @Author: ij34
 * @Date: 2024-06-25
 */

public class LC238 {

    public int[] productExceptSelf(int[] nums) {
        int[] a = new int[nums.length],b=new int[nums.length];
        int len=nums.length;
        a[0]=nums[0];
        b[len-1]=nums[len-1];
        for (int i=1;i<len;i++){
            a[i]=a[i-1]*nums[i];
            b[len-i-1]=b[len-i]*nums[len-i-1];
        }
        int[] res=new int[len];
        res[0]=b[1];
        res[len-1]=a[len-2];
        for (int i=1;i<len-1;i++){
            res[i]=a[i-1]*b[i+1];
        }

        return res;
    }



}
