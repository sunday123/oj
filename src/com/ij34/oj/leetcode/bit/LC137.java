package com.ij34.oj.leetcode.bit;

/**
 * 137. 只出现一次的数字 II
 *  https://leetcode.cn/problems/single-number-ii/description/
 *
 * @Author: ij34
 * @Date: 2024-06-25
 */

public class LC137 {


    public  int singleNumber(int[] nums) {
        int res=0;

        for (int i=0;i<32;i++){
            int sum=0;
            for (int j=0;j<nums.length;j++){
               int num=nums[j];
                sum+=(num & 1);
                nums[j]=num>>=1;
            }
            res+= (sum%3)<<i;
        }
        return res;
    }

}
