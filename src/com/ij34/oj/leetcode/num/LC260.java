package com.ij34.oj.leetcode.num;

/**
 * 260. 只出现一次的数字 III
 * https://leetcode.cn/problems/single-number-iii/description/
 *
 * @Author: ij34
 * @Date: 2024-06-25
 */

public class LC260 {
    public int[] singleNumber(int[] nums) {
        //找出2个数字不同的位的位置
        int a=0;//异或2个数
        for (int num:nums){
            a^=num;
        }

        int bit=a&(-a);//找不同的位
//        while ((bit&a)<1){
//           bit<<=1;
//        }
        //拆分为2部分，2部分相当于2个相同的数只有1个不同
        int i=0,j=0;
        for (int num:nums){
            if ((num&bit)==0){
                i^=num;
            }else {
                j^=num;
            }

        }
        return new int[]{i,j};

    }
}
