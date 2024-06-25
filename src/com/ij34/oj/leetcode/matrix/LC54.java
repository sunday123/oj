package com.ij34.oj.leetcode.matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * 54. 螺旋矩阵
 * https://leetcode.cn/problems/spiral-matrix
 *
 * @Author: ij34
 * @Date: 2024-06-25
 */

public class LC54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n=matrix.length,m=matrix[0].length;
        if (n==1&&m==1){
            return List.of(matrix[0][0]);
        }
        List<Integer> list = new ArrayList<>();
        int i=0,j=0,count=0,MAX=101;
        while (count<n*m){
            while (j<m && matrix[i][j]!=MAX){
                list.add(matrix[i][j]);
                matrix[i][j]=MAX;
                j++;
                count++;
            }
            j--;
            i++;

            while (i<n && matrix[i][j]!=MAX){
                list.add(matrix[i][j]);
                matrix[i][j]=MAX;
                i++;
                count++;
            }

            i--;
            j--;

            while (j>=0 && matrix[i][j]!=MAX){
                list.add(matrix[i][j]);
                matrix[i][j]=MAX;
                j--;
                count++;

            }
            j++;
            i--;

            while (i>=0 && matrix[i][j]!=MAX){
                list.add(matrix[i][j]);
                matrix[i][j]=MAX;
                i--;
                count++;
            }

            i++;
            j++;

        }
        return list;

    }

}
