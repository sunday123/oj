package com.ij34.oj.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 只出现一次的数字
 * https://leetcode.cn/problems/single-number/description/?envType=study-plan-v2&envId=top-100-liked
 * @Author: ij34
 * @Date: 2024-05-09
 */

public class SingleNumberOj {
    public static void main(String[] args) {
        int a=2,b=2;
        System.out.println(a^a&a);
    }
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num :nums){
            res^=num;
        }
        return res;
//        List<Integer> list = new ArrayList<>();
//        for (int num :nums){
//            if (list.contains(num)){
//                Integer n = num;
//                list.remove(n);
//            }else {
//                list.add(num);
//            }
//        }
//         return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
