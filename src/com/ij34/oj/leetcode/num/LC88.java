package com.ij34.oj.leetcode.num;


/**
 *
 * 88. 合并两个有序数组
 * https://leetcode.cn/problems/merge-sorted-array
 *
 * @Author: ij34
 * @Date: 2024-06-25
 */

public class LC88 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
      if (n<1){
          return;
      }
      if (m<1){
          for (int i=0;i<n;i++){
              nums1[i]=nums2[i];
          }
          return;
      }
      int start=0;
      for (int insert:nums2){
          while (insert>nums1[start] && start<m){
              start++;
          }
          int movePre=m;//start后移
          while (movePre<nums1.length && movePre>start){
              nums1[movePre]=nums1[movePre-1];
              movePre--;
          }
          nums1[start]=insert;
          m++;
      }



    }



}
