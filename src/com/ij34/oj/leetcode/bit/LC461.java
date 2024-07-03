package com.ij34.oj.leetcode.bit;

/**
 * 461. 汉明距离
 * https://leetcode.cn/problems/hamming-distance
 *
 * @Author: ij34
 * @Date: 2024-07-03
 */

public class LC461 {
    public int hammingDistance(int x, int y) {
         int res=0;
         while (x>0 || y>0){
             res+=Math.abs((x&1) -(y&1));
             x>>=1;
             y>>=1;
         }
         return res;
    }

}
