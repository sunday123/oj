package com.ij34.oj.leetcode.matrix;

/**
 * 48. 旋转图像
 * https://leetcode.cn/problems/rotate-image
 *
 * @Author: ij34
 * @Date: 2024-06-25
 */

public class LC48 {
    public void rotate(int[][] matrix) {
        int n=matrix.length;
        for (int i=0;i<n/2;i++){//上下交换
            int[] temp = matrix[i];
            matrix[i]=matrix[n-i-1];
            matrix[n-i-1]=temp;
        }

        //ij交换
        for (int i=0;i<n-1;i++){
            for (int j=i+1;j<n;j++){
                int temp = matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
    }


}
