package com.ij34.oj.leetcode.dp;

/**
 * 最小路径和
 * https://leetcode.cn/problems/minimum-path-sum/description/?envType=study-plan-v2&envId=top-100-liked
 * @Author: ij34
 * @Date: 2024-05-09
 */

public class MinPathSumOj {
    public int minPathSum(int[][] grid) {
      int[][] dp = new int[grid.length][grid[0].length];
      int preSum=0;
      for (int i=0;i< grid.length;i++){
          dp[i][0]=grid[i][0]+preSum;
          preSum+=grid[i][0];
      }
      preSum = grid[0][0];
      for (int i=1;i<grid[0].length;i++){
          dp[0][i]=grid[0][i]+preSum;
          preSum+=grid[0][i];
      }
      for (int i=1;i< grid.length;i++){
          for (int j=1;j<grid[0].length;j++){
              dp[i][j]=grid[i][j]+Math.min(dp[i][j-1],dp[i-1][j]);
          }
      }
      return dp[grid.length-1][grid[0].length-1];

    }
}
