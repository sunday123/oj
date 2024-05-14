package com.ij34.oj.leetcode.dbfs;


/**
 * 200. 岛屿数量
 * https://leetcode.cn/problems/number-of-islands
 * @Author: ij34
 * @Date: 2024-05-10
 */

public class NumIslandsOj {

    public static void main(String[] args) {
        char[][] d = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };

        char[][] grid = {
                {'1', '1', '1'},
                {'0', '1', '0'},
                {'1', '1', '1'}
        };
        int n = new NumIslandsOj().numIslands(d);
        System.out.println("res:"+n);
    }


    public int numIslands(char[][] grid) {
        int res = 0;
        for (int i=0;i< grid.length;i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    dfs(grid,i,j);
                }
            }
        }
       return res;
    }
    //把连通的设置为0
    private void dfs(char[][] grid, int i, int j) {
        if (i<0 || i >= grid.length || j<0 || j>=grid[0].length || grid[i][j]=='0'){
            return;
        }
        grid[i][j]='0';
        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
        for (int[] d : dir){
            dfs(grid,i+d[0],j+d[1]);
        }
    }


}
