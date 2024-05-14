package com.ij34.oj.leetcode.ingenious;

/**
 * 287. 寻找重复数
 * 其数字都在 [1, n] 范围内（包括 1 和 n），可知至少存在一个重复的整数
 * @Author: ij34
 * @Date: 2024-05-11
 */

public class FindDuplicate {
    public static void main(String[] args) {
        int[] a = new int[]{4,3,1,4,2};
        System.out.println(findDuplicate(a));
    }
    public static int findDuplicate(int[] nums) {
          int slow =0, fast =0;
          while (true){
              fast=nums[nums[fast]];
              slow = nums[slow];
              if (fast==slow){
                  break;
              }
          }
          slow=0;
          while (true){
            slow=nums[slow];
            fast=nums[fast];
            if (fast==slow){
                break;
            }
          }
          return slow;

    }
}
