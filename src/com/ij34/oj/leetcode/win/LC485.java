package com.ij34.oj.leetcode.win;

/**
 * 485. 最大连续 1 的个数
 * https://leetcode.cn/problems/max-consecutive-ones
 *
 * @Author: ij34
 * @Date: 2024-07-09
 */

public class LC485 {

    public int findMaxConsecutiveOnes(int[] nums) {
        int l=0,r,len=nums.length,max=0;
        while (l<len &&nums[l]!=1){
            l++;
        }
        r=l;

        while (r<len){
            if (nums[r]==1){
                r++;
                continue;
            }
            max=Math.max(r-l,max);
            l=r+1;

            while (l<len && nums[l]!=1){
                l++;
            }
            r=l;


        }
        max=Math.max(r-l,max);
        return max;

    }

}
