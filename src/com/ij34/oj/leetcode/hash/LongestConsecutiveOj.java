package com.ij34.oj.leetcode.hash;

import java.util.HashSet;

/**
 * 128. 最长连续序列
 * https://leetcode.cn/problems/longest-consecutive-sequence/description/?envType=study-plan-v2&envId=top-100-liked
 * @Author: ij34
 * @Date: 2024-05-10
 */

public class LongestConsecutiveOj {

    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num:nums){
            set.add(num);
        }
        int longest=0;
        for (int num:nums){
            if (!set.contains(num+1)){ //找边界
                int current =1;
                while (set.contains(--num)){
                    current++;
                }
                longest=longest>current?longest:current;
            }
        }
        return longest;
    }
}
