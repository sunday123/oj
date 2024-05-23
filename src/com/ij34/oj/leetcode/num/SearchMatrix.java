package com.ij34.oj.leetcode.num;

/**
 * 74. 搜索二维矩阵
 * https://leetcode.cn/problems/search-a-2d-matrix
 * @Author: ij34
 * @Date: 2024-05-23
 */

public class SearchMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        return searchMatrix(matrix,target,0, matrix.length*matrix[0].length-1);
    }

    private boolean searchMatrix(int[][] matrix, int target, int start, int end) {
        if (end<start){
            return false;
        }
        System.out.println(start+"-"+end);
        int mid =start+(end-start)/2;
        int x = mid/matrix[0].length,y=mid%matrix[0].length;
        if (matrix[x][y]==target){
            return true;
        }else if (target>matrix[x][y]){
            return searchMatrix(matrix,target,mid+1,end);
        }else if (target<matrix[x][y]){
            return searchMatrix(matrix, target, start, mid-1);
        }
        return false;
    }
}
