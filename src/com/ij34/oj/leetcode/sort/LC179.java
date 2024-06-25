package com.ij34.oj.leetcode.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 179. 最大数
 * https://leetcode.cn/problems/largest-number
 *
 * @Author: ij34
 * @Date: 2024-06-25
 */

public class LC179 {


    public String largestNumber(int[] nums) {
        List<String> list = new ArrayList<>();
        for (int num:nums){
            list.add(String.valueOf(num));
        }
        Collections.sort(list, (a, b) -> {
            return (b+a).compareTo(a+b);
        });
        if (list.get(0).charAt(0)=='0'){
            return "0";
        }else {
            return list.stream().collect(Collectors.joining());
        }
    }


}
