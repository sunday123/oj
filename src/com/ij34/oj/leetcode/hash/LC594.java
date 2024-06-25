package com.ij34.oj.leetcode.hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 594. 最长和谐子序列
 * https://leetcode.cn/problems/longest-harmonious-subsequence
 *
 * @Author: ij34
 * @Date: 2024-06-25
 */

public class LC594 {
    public int findLHS(int[] nums) {
      Map<Integer,Integer> map = new HashMap<>();
      for (int num:nums){
          map.put(num,map.getOrDefault(num,0)+1);

      }
      int max=0;
      for (Integer key: map.keySet()){
          if (map.containsKey(key+1)){
              max=Math.max(max,map.get(key)+map.get(key+1));
          }
      }
      return max;
    }

}
