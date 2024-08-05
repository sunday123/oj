package com.ij34.oj.leetcode.array;

/**
 * 80. 删除有序数组中的重复项 II
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-array-ii/
 *
 * @Author: ij34
 * @Date: 2024-08-05
 */

public class LC80 {

    public int removeDuplicates(int[] nums) {
        int current=Integer.MIN_VALUE,count=0,i=0;
        for (int num:nums){
            if (num!=current){
                nums[i++]=num;
                current=num;
                count=1;
                continue;
            }
            count++;
            if (count<3){
                nums[i++]=num;
            }

        }
        return i;
    }

}
