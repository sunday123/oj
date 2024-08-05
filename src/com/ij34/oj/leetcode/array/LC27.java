package com.ij34.oj.leetcode.array;

/**
 * 27. 移除元素
 * https://leetcode.cn/problems/remove-element
 *
 * @Author: ij34
 * @Date: 2024-08-05
 */

public class LC27 {
    public int removeElement(int[] nums, int val) {
        int i=0;
        for (int num : nums){
            if (num!=val){
                nums[i++]=num;
            }
        }
        return i;

    }

}
