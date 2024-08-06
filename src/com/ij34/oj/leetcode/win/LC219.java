package com.ij34.oj.leetcode.win;

import java.util.HashSet;

/**
 * 219. 存在重复元素 II
 * https://leetcode.cn/problems/contains-duplicate-ii
 *
 * @Author: ij34
 * @Date: 2024-08-06
 */

public class LC219 {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        int r=Math.min(k,nums.length-1);
        for (int i=0;i<=r;i++){
            if (set.add(nums[i])==false){
                return true;
            }
        }
        int l=0;
        while (++r<nums.length){
            set.remove(nums[l++]);
            if (set.add(nums[r])==false){
                return true;
            }
        }
        return false;
    }

}
