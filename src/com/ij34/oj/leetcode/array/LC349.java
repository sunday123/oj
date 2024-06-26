package com.ij34.oj.leetcode.array;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 349. 两个数组的交集
 * https://leetcode.cn/problems/intersection-of-two-arrays/description/
 *
 * @Author: ij34
 * @Date: 2024-06-23
 */

public class LC349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        set.retainAll(Arrays.stream(nums2).boxed().collect(Collectors.toSet()));
        return set.stream().mapToInt(Integer::intValue).toArray();
    }
}
