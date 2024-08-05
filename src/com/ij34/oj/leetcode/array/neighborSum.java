package com.ij34.oj.leetcode.array;

import java.util.Map;

/**
 * @Author: ij34
 * @Date: 2024-08-04
 */

public class neighborSum {
    private int[][] grid;
    private int[][] adjacent = {{1,0},{-1,0},{0,1},{0,-1}};
    private int[][] diagonal = {{1,1},{-1,1},{1,-1},{-1,-1}};

    public neighborSum(int[][] grid) {
         this.grid=grid;

    }

    public int adjacentSum(int value) {
        int[] xy =getXY(value);
        int x=xy[0],y=xy[1];
        int sum=0;
        for (int[] d : adjacent){
            int i=x+d[0],j=y+d[1];
            if (i>=0&&i<grid.length && j>=0 && j<grid[0].length){
                sum+=grid[i][j];
            }
        }
        return sum;

    }

    public int diagonalSum(int value) {
        int[] xy =getXY(value);
        int x=xy[0],y=xy[1];
        int sum=0;
        for (int[] d : diagonal){
            int i=x+d[0],j=y+d[1];
            if (i>=0&&i<grid.length && j>=0 && j<grid[0].length){
                sum+=grid[i][j];
            }
        }
        return sum;
    }
    private int[] getXY(int value){
        for (int i=0;i<grid.length;i++){
            for (int j=0;j<grid[0].length;j++){
                if (grid[i][j]==value){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }
}
