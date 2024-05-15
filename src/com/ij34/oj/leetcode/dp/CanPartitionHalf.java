package com.ij34.oj.leetcode.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 416分割等和子集
 * https://leetcode.cn/problems/partition-equal-subset-sum
 * 经典01背包问题
 *
 * @Author: ij34
 * @Date: 2024-05-14
 */

public class CanPartitionHalf {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum%2==1){
            return false;
        }
        sum/=2;
        int[][] dp = new int[nums.length+1][sum+1];
        for (int i=1;i<=nums.length;i++){
            for (int w=1;w<=sum;w++){
                if (nums[i-1]>w){
                    dp[i][w]=dp[i-1][w];
                }else {
                    dp[i][w]=Math.max(dp[i-1][w],dp[i-1][w-nums[i-1]]+nums[i-1]);
                }

                if (dp[i][w]==sum){
                    return true;
                }
            }
        }
        return dp[nums.length][sum]==sum;
    }



}
