package com.ij34.oj.leetcode.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * 994. 腐烂的橘子
 * https://leetcode.cn/problems/rotting-oranges
 * @Author: ij34
 * @Date: 2024-05-13
 */

public class OrangesRottingOj {
    public static void main(String[] args) {
        int[][] grid = {
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        };
        System.out.println(orangesRotting(grid));
    }
    public static int orangesRotting(int[][] grid) {
        int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
        List<int[]> list2 = new ArrayList<>();//腐烂
        for (int i=0;i<grid.length;i++){
            for (int j=0;j<grid[0].length;j++){
                if (grid[i][j]==2){
                    list2.add(new int[]{i,j});
                    grid[i][j]=0;
                }
            }
        }
        int res=0;
        while (list2.isEmpty()==false){
            boolean isAdd=false;
            List<int[]> tempList = new ArrayList<>(list2);
            list2.clear();
            for (int[] a: tempList){
                for (int[] d : dir){
                    int x =a[0]+d[0],y=a[1]+d[1];
                    if (x>=0 && y>=0 && x<grid.length && y<grid[0].length){
                        if (grid[x][y]==1){
                            isAdd=true;
                            list2.add(new int[]{x,y});
                            grid[x][y]=0;
                        }
                    }
                }
            }
            if (isAdd){
                res++;
            }
        }
        for (int i=0;i<grid.length;i++){
            for (int j=0;j<grid[0].length;j++){
                if (grid[i][j]==1){
                    return -1;
                }
            }
        }
        return res;
    }
}
