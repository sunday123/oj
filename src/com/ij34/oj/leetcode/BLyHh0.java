package com.ij34.oj.leetcode;

import java.util.ArrayDeque;

/**
 * LCR 116. 省份数量
 * https://leetcode.cn/problems/bLyHh0/description/
 * @Author: ij34
 * @Date: 2024-05-10
 */

public class BLyHh0 {
    public int findCircleNum(int[][] isConnected) {
        int[] f = new int[isConnected.length];
        int res =0;
        for (int i=0;i< isConnected.length;i++){
            if (f[i]==0){
                res++;
            }
            //比如abcd,0行是ad,再找d行或d列，d列中找连同而且f中没有被访问过的放进deque中
            ArrayDeque<Integer> deque = new ArrayDeque<>();
            for (int j=i;j<isConnected[0].length;j++){
                if (isConnected[i][j]==1){
                    f[j]=1;
                    deque.addLast(j);
                }
            }
            while (deque.isEmpty()==false){
                   int jj =deque.peekFirst();
                   deque.removeFirst();
                   for (int ii=0;ii<isConnected.length;ii++){
                       if (isConnected[ii][jj]==1 && f[ii]==0){
                           f[ii]=1;
                           deque.addLast(ii);
                       }
                   }
            }

        }
        return res;
    }
}
