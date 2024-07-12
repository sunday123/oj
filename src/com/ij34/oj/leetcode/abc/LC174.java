package com.ij34.oj.leetcode.abc;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @Author: ij34
 * @Date: 2024-07-08
 */

public class LC174 {
    public static void main(String[] args) {
        LC174 c =new LC174();
//        int[][] a = {{-2,-3,3},{-5,-10,1},{10,30,-5}};
        int[][] a={{0,0,0},{-1,0,0},{2,0,-2}};
        System.out.println(c.calculateMinimumHP(a));


    }
    public int calculateMinimumHP(int[][] dungeon) {
        int n=dungeon.length,m=dungeon[0].length;
        System.out.println(n);
        System.out.println(m);
        initArray=new int[n][m];
        curArray=new int[n][m];
        for (int i=0;i<n;i++){
            Arrays.fill(initArray[i],Integer.MAX_VALUE);
        }
        initArray[0][0]=dungeon[0][0]>=0?0:0-dungeon[0][0];


        curArray[0][0]=dungeon[0][0]<=0?0:dungeon[0][0];


        int[][] dir = {{0,1},{1,0}};
        LinkedList<int[]> list = new LinkedList<>();
        list.add(new int[]{0,0,initArray[0][0],curArray[0][0]});
        while (list.size()>0){
            int[] poll = list.removeFirst();
            for (int[] d:dir){
                int x=poll[0]+d[0],y=poll[1]+d[1];
                if (x<0 || x>=n || y<0 || y>=m){
                    continue;
                }
                int curInit=poll[2];
                int curCap=dungeon[x][y]+poll[3];
                if (curCap<0){
                    curInit-=curCap;
                    curCap=0;
                }

                if (curInit>initArray[x][y]){
                    continue;
                }
                if (curCap-curInit<=curArray[x][y]-initArray[x][y]){
                    continue;
                }
                if (curInit<initArray[x][y]){
                    initArray[x][y]=curInit;
                    curArray[x][y]=curCap;
                    list.addLast(new int[]{x,y,curInit,curCap});
                }else if (curCap-curInit>poll[3]-poll[2]){
                    list.addLast(new int[]{x,y,curInit,curCap});
                }




            }
        }

//       for (int i=0;i<n;i++){
//           System.out.println(Arrays.toString(initArray[i]));
//       }


        return initArray[n-1][m-1]+1;

    }




    private int[][] initArray, curArray;




}
