package com.ij34.oj.leetcode.array;

import java.util.*;

/**
 * 1695. 删除子数组的最大得分
 * https://leetcode.cn/problems/maximum-erasure-value/description/
 * @Author: ij34
 * @Date: 2024-06-23
 */

public class LC1695 {


    public int maximumUniqueSubarray(int[] nums) {
        int l=0,r=0,win=0,len=nums.length,max = 0;
        Set<Integer> set = new HashSet<>();

        while (r<len){
            if (set.contains(nums[r])==false){
                win+=nums[r];
                set.add(nums[r]);
                r++;
                continue;
            }else {
                max=Math.max(max,win);
                while (set.contains(nums[r])){
                    win-=nums[l];
                    set.remove((Integer) nums[l]);
                    l++;
                }

            }

        }
        max=Math.max(max,win);
        return max;
    }



}
