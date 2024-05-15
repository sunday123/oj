package com.ij34.oj.leetcode.dp;

/**
 * 152. 乘积最大子数组
 * https://leetcode.cn/problems/maximum-product-subarray
 *
 * @Author: ij34
 * @Date: 2024-05-14
 */

public class MaxProduct {

    public int maxProduct(int[] nums) {
         int[] dp = new int[nums.length];
         dp[0]=nums[0];
         int res =Integer.MIN_VALUE,max=1,min=1;

         for (int i=0;i<nums.length;i++){
             if(nums[i]<0){
                 int t=max;
                 max=min;
                 min=t;
             }
            max=Math.max(max*nums[i],nums[i]);
            min=Math.min(min*nums[i],nums[i]);
            res=Math.max(max,res);

         }
         return res;
    }

}
