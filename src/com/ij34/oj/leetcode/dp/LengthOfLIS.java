package com.ij34.oj.leetcode.dp;

import java.util.Arrays;

/**
 * 300. 最长递增子序列
 * https://leetcode.cn/problems/longest-increasing-subsequence
 *
 * @Author: ij34
 * @Date: 2024-05-14
 */

public class LengthOfLIS {
    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[]{7,7,7,7,7}));
    }
    public static int lengthOfLIS(int[] nums) {
        int max=1;
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        for (int i=1;i<nums.length;i++){
             for (int j=0;j<i;j++){
                 if (nums[i]>nums[j]){
                     dp[i]=Math.max(dp[i],dp[j]+1);
                 }
             }
             if (dp[i]>max){
                 max=dp[i];
             }
        }
       return max;
    }
}
