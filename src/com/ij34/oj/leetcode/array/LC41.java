package com.ij34.oj.leetcode.array;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 41. 缺失的第一个正数
 * https://leetcode.cn/problems/first-missing-positive
 *
 * @Author: ij34
 * @Date: 2024-06-26
 */

public class LC41 {

    public int firstMissingPositive(int[] nums) {
        int n=nums.length;
        for (int i=0;i<nums.length;){
            if (nums[i]<=n && nums[i]>0 && nums[i]!=nums[nums[i]-1]){
                int index =nums[i]-1;
                int temp =nums[index];
                nums[index]=nums[i];
                nums[i]=temp;

            }else {
                i++;
            }
            System.out.println(i);
            System.out.println(Arrays.toString(nums));

        }

        for (int i=0;i<n;i++){
            if (nums[i]-1!=i){
                return i+1;
            }
        }



         return n+1;
    }

}
