package com.ij34.oj.leetcode.game.weekend;

import java.util.Arrays;

/**
 * @Author: ij34
 * @Date: 2024-05-28
 */

public class Main {

    public int maximumSumSubsequence(int[] nums, int[][] queries) {
        int res=0;
        for (int[] q : queries){
             nums[q[0]]=q[1];
             res+=massage(nums);
        }
       return res;
    }

    public static void main(String[] args) {
        System.out.println(new Main().massage(new int[]{3,-2,9,10,11,110}));
    }


    public int massage(int[] nums) {
        int[] dp = new int[nums.length+2];
        for (int i=nums.length-1;i>=0;i--){
            dp[i]=Math.max(dp[i+1],dp[i+2]+nums[i]);
        }
        System.out.println(Arrays.toString(dp));
        return dp[0];
    }
}
