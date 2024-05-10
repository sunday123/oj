package com.ij34.oj.leetcode;

import java.util.Arrays;

/**
 * 283. 移动零
 * https://leetcode.cn/problems/move-zeroes/description/?envType=study-plan-v2&envId=top-100-liked
 * @Author: ij34
 * @Date: 2024-05-10
 */

public class MoveZeroes {
    public static void main(String[] args) {
        int[] a =new int[]{0,1,0,3,12};
        moveZeroes(a);
        System.out.println(Arrays.toString(a));
    }

    public static void moveZeroes(int[] nums) {
      if (nums.length<2){
          return;
      }
      for (int i=0;i<nums.length;i++){
           if (nums[i]==0){
               for (int j=i+1;j<nums.length;j++){
                   if (nums[j]!=0){
                       int t= nums[i];
                       nums[i]=nums[j];
                       nums[j]=t;
                       break;
                   }
               }
           }
      }
    }
}
