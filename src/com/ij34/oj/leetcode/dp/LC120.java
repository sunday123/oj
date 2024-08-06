package com.ij34.oj.leetcode.dp;

import java.util.Arrays;
import java.util.List;

/**
 * 120. 三角形最小路径和
 * https://leetcode.cn/problems/triangle
 *
 * @Author: ij34
 * @Date: 2024-07-10
 */

public class LC120 {

    public int minimumTotal(List<List<Integer>> triangle) {
        int len=triangle.size();
        int[][] dp = new int[len+1][len+1];
        for (int i=len-1;i>=0;i--){
            for (int j=0;j<triangle.get(i).size();j++){
                dp[i][j]=triangle.get(i).get(j)+Math.min(dp[i+1][j],dp[i+1][j+1]);
            }

        }


        return dp[0][0];


    }



}
