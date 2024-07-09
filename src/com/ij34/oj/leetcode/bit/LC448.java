package com.ij34.oj.leetcode.bit;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

/**
 * 448. 找到所有数组中消失的数字
 * https://leetcode.cn/problems/find-all-numbers-disappeared-in-an-array
 *
 * @Author: ij34
 * @Date: 2024-07-03
 */

public class LC448 {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        BitSet set = new BitSet();
        for (int i : nums){
            set.set(i);
        }
        List<Integer> list = new ArrayList<>();
        for (int i=1;i<=nums.length;i++){
            if (set.get(i)==false){
                list.add(i);
            }
        }
        return list;
    }

}
