package com.ij34.oj.leetcode.sub;

import java.util.Arrays;

/**
 * 16. 最接近的三数之和
 * https://leetcode.cn/problems/3sum-closest/description/
 *
 * @Author: ij34
 * @Date: 2024-06-23
 */

public class LC16 {

    public int threeSumClosest(int[] nums, int target) {
        int res=nums[0]+nums[1]+nums[2];
        for (int i=0;i<nums.length;i++){
            for (int j=i+1;j<nums.length;j++){
                for (int k=j+1;k<nums.length;k++){
                    int sum=nums[i]+nums[j]+nums[k];
                    if (Math.abs(target-sum)<Math.abs(target-res)){
                        res=sum;
                    }

                }


            }
        }
        return res;
    }


}
