package com.ij34.oj.leetcode.bit;

/**
 * 338. 比特位计数
 * https://leetcode.cn/problems/counting-bits
 *
 * @Author: ij34
 * @Date: 2024-07-04
 */

public class LC338 {

    public int[] countBits(int n) {

      int[] res = new int[n+1];
      for (int i=0;i<res.length;i++){
          int j=i;
          while (j>0){
              res[i]+=j&1;
              j>>=1;
          }

      }
      return res;




    }


}
