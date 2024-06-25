package com.ij34.oj.leetcode.matrix;

/**
 * 240. 搜索二维矩阵 II
 * https://leetcode.cn/problems/search-a-2d-matrix-ii
 *
 * @Author: ij34
 * @Date: 2024-06-25
 */

public class LC240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n= matrix.length,m=matrix[0].length;
        int x=n-1,y=0;
//        if (target<matrix[0][0] || target>matrix[n-1][m-1]){
//            return false;
//        }
//        if (matrix[x][y]==target){
//            return true;
//        }
        while (x>=0 && y<m){

          if (target==matrix[x][y]){
              return true;
          }else if (target<matrix[x][y]){
              x--;
          }else {
              y++;
          }

        }
        return false;

    }



}
