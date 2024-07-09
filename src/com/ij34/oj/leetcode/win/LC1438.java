package com.ij34.oj.leetcode.win;

import java.util.TreeMap;

/**
 * @Author: ij34
 * @Date: 2024-07-09
 */

public class LC1438 {
    public int longestSubarray(int[] nums, int limit) {
        TreeMap<Integer,Integer> winMap = new TreeMap<>();
        int l=0,r=0,len=nums.length,max=0;
        while (r<len){
            winMap.put(nums[r],winMap.getOrDefault(nums[r],0)+1);
            r++;
            while (winMap.isEmpty()==false && winMap.lastKey()-winMap.firstKey()>limit){
               int count= winMap.get(nums[l]);
               if (count==1){
                   winMap.remove((Integer) nums[l]);
               }else {
                   winMap.put(nums[l],winMap.get(nums[l])-1);
               }
               l++;

            }
            max=Math.max(max,r-l);


        }
        return max;
    }

}
