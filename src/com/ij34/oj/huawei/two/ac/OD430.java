package com.ij34.oj.huawei.two.ac;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 智能驾驶
 * https://hydro.ac/d/HWOD2023/p/OD430
 * @Author: ij34
 * @Date: 2024-06-15
 */

public class OD430 {
    private static int n,m;
    private static int[][] a;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nm = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::valueOf).toArray();
        n=nm[0];
        m=nm[1];
        a=new int[n][m];
        for (int i=0;i<n;i++){
            a[i]=Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::valueOf).toArray();
        }
        System.out.println(bfs());



    }
    private static boolean[][] conn;
    private static int bfs() {
        conn= new boolean[n][m];
        if (a[0][0]==0 || a[0][0]>100 || a[n-1][m-1]==0){
            return -1;
        }
        int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}},initArray=new int[n][m],remainArray=new int[n][m];
        for (int i=0;i<n;i++){
            Arrays.fill(initArray[i],Integer.MAX_VALUE);
        }
        //判断消耗油量是否可达
        LinkedList<int[]> list = new LinkedList<>();
        //x,y,初始化需要油量，剩余油量，是否加过油
        list.add(new int[]{0,0,a[0][0]==-1?0:a[0][0],a[0][0]==-1?100:0,a[0][0]==-1?1:0});
        while (list.isEmpty()==false){
            int[] poll = list.poll();
            for (int[] d: dir){
                int x=poll[0]+d[0],y=poll[1]+d[1],init=poll[2],remain=poll[3],flag=poll[4];
                if (x<0 || x>=n || y<0 || y>=m || a[x][y]==0){
                    continue;
                }
                if (a[x][y]==-1){
                    remain=100;
                    flag=1;
                }else {
                    remain-=a[x][y];
                }

                if (remain<0){
                    if (flag>0){
                        continue;
                    }else {
                        init-=remain;
                        if (init>100){
                            continue;
                        }
                        remain=0;

                    }
                }

                if (init>initArray[x][y]){
                    continue;
                }

                if (init<initArray[x][y] || remain>remainArray[x][y]){
                    initArray[x][y]=init;
                    remainArray[x][y]=remain;

                    list.add(new int[]{x,y,init,remain,flag});
                }
            }
        }
        return initArray[n-1][m-1]==Integer.MAX_VALUE?-1:initArray[n-1][m-1];
    }

}
