package com.ij34.oj.leetcode.search.binary;

/**
 * @Author: ij34
 * @Date: 2024-07-09
 */

public class LC1802 {
    public int maxValue(int n, int index, int maxSum) {
          long l=1,r=maxSum,res=0;
          while (l<=r){
              long mid=(l+r)/2;
              if (check(n,index,maxSum,mid)){
                  res=mid;
                  l=mid+1;
              }else {
                  r=mid-1;
              }

          }
          return (int)res;
    }

    private boolean check(int n, int index, long maxSum, long mid) {
        return countSum(mid,index+1)+countSum(mid,n-index)-mid<=maxSum;

    }

    private long countSum(long max, long len) {
        if (len<max){//2 3山峰
            return (max-len+1+max)*len/2; //等差和
        }else { // 1 1 2 3
            return (1+max)*max/2+(len-max);
        }
    }

}
