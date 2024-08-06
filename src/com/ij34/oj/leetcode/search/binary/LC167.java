package com.ij34.oj.leetcode.search.binary;

/**
 * 167. 两数之和 II - 输入有序数组
 * https://leetcode.cn/problems/two-sum-ii-input-array-is-sorted
 *
 * @Author: ij34
 * @Date: 2024-08-06
 */

public class LC167 {
    public int[] twoSum(int[] numbers, int target) {
        int l=0,r=numbers.length-1;
        while (l<r){
            if (numbers[l]+numbers[r]==target){
                return new int[]{l+1,r+1};
            }else if (numbers[l]+numbers[r]>target){
                r--;
            }else {
                l++;
            }

        }
        return new int[]{l+1,r+1};

    }
}
