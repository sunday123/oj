package com.ij34.oj.leetcode.abc;

import java.util.*;

/**
 * @Author: ij34
 * @Date: 2024-07-04
 */

public class LC221 {
    private int n,m,nm;
    public int maximalSquare(char[][] matrix) {
        int max=0;
        n=matrix.length;
        m=matrix[0].length;
        nm=n+m;
        int minLen =Math.max(n,m)/2;
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){

                if (matrix[i][j]=='1'){
                    if (max<1){
                        max=1;
                    }
                    if (j+max>m){
                        continue;
                    }

                    if (j>0 && matrix[i][j-1]=='1'){
                        continue;
                    }
                    int size = getSize(matrix,i,j);
                    max=Math.max(max,size);

                    if (max>minLen){
                        return max*max;
                    }
                }


            }
        }
        return max*max;
    }

    private int getSize(char[][] matrix, int x, int y) {
        int size=1;
        LinkedList<Integer> list = new LinkedList<>();//向右\向下\向右下 扩散
        int xy =x*nm+y;
        list.add(xy);
        int[][] dir = {{1,0},{0,1},{1,1}};
        int a=xy/nm;
        while (true){
            int len=list.size();
            for (int i=0;i<len;i++){
                int sum = list.get(i);
                int xx=sum/nm,yy=sum%nm;
                for (int[] d:dir){
                    int curX=d[0]+xx,curY=d[1]+yy;
                    if (curX<0 || curX>=n || curY<0 || curY>=m || matrix[curX][curY]=='0'){
                        return size;
                    }
                    int s=curX*nm+curY;
                    if (list.contains(s)==false){
                        list.addLast(s);
                    }

                }
            }
            size++;
            for (int i=0;i<len;i++){
                list.removeFirst();
            }


        }

    }

}
