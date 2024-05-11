package com.ij34.oj.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 47. 全排列 II
 * https://leetcode.cn/problems/permutations-ii/
 * @Author: ij34
 * @Date: 2024-05-11
 */

public class PermuteUnique {
    List<Integer> hash = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums,0,res);
        return res;
    }

    private void backtrack(int[] nums, int index, List<List<Integer>> res) {
        if (index==nums.length) {
            int code = Arrays.toString(nums).hashCode();
            if (!hash.contains(code)) {
                hash.add(code);
//                System.out.println(Arrays.toString(nums));
                res.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
            }
            return;
        }
        for (int i=index;i<nums.length;i++){
            if (i!=index && nums[i]==nums[index]){
                continue;
            }
            swap(nums,i,index);
            backtrack(nums,index+1,res);
            swap(nums,i,index);
        }


    }

    private void swap(int[] nums, int i, int index) {
        int t =nums[i];
        nums[i] = nums[index];
        nums[index] =t;
    }
}
