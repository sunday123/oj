package com.ij34.oj.leetcode.win;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 239. 滑动窗口最大值
 * https://leetcode.cn/problems/sliding-window-maximum
 * @Author: ij34
 * @Date: 2024-06-26
 */

public class LC239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length<2){
            return nums;
        }
        if (k>=nums.length){
            return new int[]{Arrays.stream(nums).max().getAsInt()};
        }


        int len=nums.length,j=0;
        int[] a = new int[len-k+1];
        ArrayDeque<Integer> deque = new ArrayDeque<>();//值从大到小，序列号从小到大
        for (int i=0;i<len;i++){
            while (deque.size()>0 && nums[deque.getLast()]<=nums[i]){
                deque.removeLast();
            }
            deque.offerLast(i);
            if (deque.getFirst()<=i-k){
                deque.removeFirst();
            }

            if (i-k+1>=0){
                a[j++]=nums[deque.getFirst()];
            }


        }
        return a;
    }
}
