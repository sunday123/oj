package com.ij34.oj.leetcode.array;

import java.util.*;

/**
 * 18. 四数之和
 * https://leetcode.cn/problems/4sum
 *
 * @Author: ij34
 * @Date: 2024-07-10
 */

public class LC18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> resList = new ArrayList<>();
        Arrays.sort(nums);
        if (nums.length<4){
            return List.of();
        }
        int len=nums.length;
        long target2=target;
        for (int i=0;i<=len-4;i++){
            for (int j=i+1;j<=len-3;j++){
                for (int k=j+1;k<=len-2;k++){
                    long t=target2-nums[i]-nums[j]-nums[k];
                    if (find(nums,k+1,len-1,t)){
                        List<Integer> list = List.of(nums[i],nums[j],nums[k],(int)t);
                        if (resList.contains(list)==false){
                            resList.add(list);
                        }


                    }


                }

            }

        }

        return resList;




    }

    private boolean find(int[] nums, int i, int j, long target) {
        while (i<=j){
            int mid=(i+j)/2;
            if (nums[mid]==target){
                return true;
            }else if (target>nums[mid]){
                i=mid+1;
            }else {
                j=mid-1;
            }
        }
        return false;
    }
}