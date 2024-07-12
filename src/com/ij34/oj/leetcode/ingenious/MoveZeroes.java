package com.ij34.oj.leetcode.ingenious;

import java.util.Arrays;

/**
 * 283. 移动零
 * https://leetcode.cn/problems/move-zeroes/description/?envType=study-plan-v2&envId=top-100-liked
 *
 * @Author: ij34
 * @Date: 2024-05-10
 */

public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        int i=0;
        for (int num:nums){
            if (num!=0){
                nums[i++]=num;
            }
        }
        while (i<nums.length){
            nums[i++]=0;
        }
    }

}
