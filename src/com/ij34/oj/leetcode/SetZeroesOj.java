package com.ij34.oj.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 73. 矩阵置零
 * https://leetcode.cn/problems/set-matrix-zeroes/description/?envType=study-plan-v2&envId=top-100-liked
 * @Author: ij34
 * @Date: 2024-05-10
 */

public class SetZeroesOj {
    public static void main(String[] args) {
        int[][] array = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };
        setZeroes(array);
        for (int[] a:array){
            System.out.println(Arrays.toString(a));
        }
    }
    public static void setZeroes(int[][] matrix) {
        List<int[]> list = new ArrayList<>();
        for (int i=0;i< matrix.length;i++){
            for (int j=0;j<matrix[0].length;j++){
                if (matrix[i][j]==0){
                    list.add(new int[]{i,j});
                }
            }
        }
        int[][] dd={{0,1},{0,-1},{1,0},{-1,0}};
        for (int[] l : list){
            int i=l[0],j=l[1];
            for (int[] d :dd){
             i+=d[0];
             j+=d[1];
             while (i>=0 && i< matrix.length && j>=0 && j<matrix[0].length){
                 matrix[i][j]=0;
                 i+=d[0];
                 j+=d[1];
             }
             i=l[0];
             j=l[1];

            }
        }

    }
}
