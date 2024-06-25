package com.ij34.oj.leetcode.num;

import java.util.Arrays;

/**
 * 189. 轮转数组
 * https://leetcode.cn/problems/rotate-array
 *
 * @Author: ij34
 * @Date: 2024-06-25
 */

public class LC189 {

    public void rotate(int[] nums, int k) {
        int len=nums.length;
        k%=len;
        if (len<2|| k==0){
            return;
        }
        int[] a= Arrays.stream(nums).toArray();
        for (int i=0;i<len;i++){
            nums[(i+k)%len]=a[i];
        }

    }



}
