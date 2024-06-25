package com.ij34.oj.leetcode.pointer;

/**
 * 11. 盛最多水的容器
 * https://leetcode.cn/problems/container-with-most-water/description/
 * 哪一边短移动哪一边
 * @Author: ij34
 * @Date: 2024-06-25
 */

public class LC11 {
    public int maxArea(int[] height) {
       int max=0,l=0,r=height.length-1;
       while (l<r){
           int sum=Math.min(height[l],height[r])*(r-l);
           max=Math.max(max,sum);
           if (l==r){
               l++;
               r--;
           }else if (height[l]>height[r]){
               r--;
           }else {
               l++;
           }
       }
       return max;
    }

}
