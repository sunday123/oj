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
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        int i=1;
        while (set.contains(i)){
            i++;
        }
        return i;


    }

}
