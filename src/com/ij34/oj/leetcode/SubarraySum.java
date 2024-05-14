package com.ij34.oj.leetcode;

import java.util.Arrays;

/**
 * 560. 和为 K 的子数组
 * https://leetcode.cn/problems/subarray-sum-equals-k
 * 不能暴力和dp，会超时和超内存。
 * @Author: ij34
 * @Date: 2024-05-14
 */

public class SubarraySum {
    public int subarraySum(int[] nums, int k) {
        int res = 0;
        for (int start=0;start<nums.length;start++){
            if (nums[start]==k) res++;
            int kk=k-nums[start];
            for (int i=start+1;i<nums.length;i++){
                if (nums[i]==kk) res++;
                kk-=nums[i];
            }
        }
        return res;
    }
}
