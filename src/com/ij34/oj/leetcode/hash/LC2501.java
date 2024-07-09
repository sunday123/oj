package com.ij34.oj.leetcode.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

/**
 * 2501. 数组中最长的方波
 * https://leetcode.cn/problems/longest-square-streak-in-an-array
 *
 * @Author: ij34
 * @Date: 2024-07-08
 */

public class LC2501 {

    public int longestSquareStreak(int[] nums) {
        BitSet bitSet = new BitSet();
        int endIndex=nums.length-1;
        Arrays.sort(nums);
        int max=1;
        for (int i=0;i<nums.length;i++){
            int num=nums[i];
            if (bitSet.get(num)){
                continue;
            }
            int len=1;
            num*=num;
            while (check(nums,num,i+1,endIndex) && bitSet.get(num)==false){
                len++;
                bitSet.set(num);
                num*=num;
            }
            max=max>len?max:len;


        }
        return max==1?-1:max;

    }

    private boolean check(int[] nums, int num, int i, int j) {
        if (i>j){
            return false;
        }
        int mid=(i+j)/2;
        if (nums[mid]==num){
            return true;
        }else if (num<nums[mid]){
            return check(nums,num,i,mid-1);
        }else {
            return check(nums,num,mid+1,j);
        }
    }

}
