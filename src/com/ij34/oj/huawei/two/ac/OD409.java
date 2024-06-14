package com.ij34.oj.huawei.two.ac;

import java.util.*;

/**
 * 路口最短时间问题
 * https://hydro.ac/d/HWOD2023/p/OD409
 * 参考csdn思路
 * @Author: ij34
 * @Date: 2024-06-13
 */

public class OD409 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] rc = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        int[][] lights = new int[rc[0]][rc[1]];
        for (int i=0;i<lights.length;i++){
            lights[i]=Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        }
        int timePreRoad = Integer.valueOf(sc.nextLine());
        int[] start = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        int[] end = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        int res=new OD409().calcTime(lights,timePreRoad,start[0],start[1],end[0],end[1]);
        System.out.println(res);

    }

    int calcTime(int[][] lights, int timePreRoad, int rowStart, int colStart, int rowEnd, int colEnd){
         int n =lights.length,m=lights[0].length;
         int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
         int[][][] dist = new int[n][m][4];
         for (int i=0;i<n;i++){
             for (int j=0;j<m;j++){
                 for (int k=0;k<4;k++){
                     dist[i][j][k]=Integer.MAX_VALUE;
                 }
             }
         }
         //起点
        PriorityQueue<int[]> priorityQueue =new PriorityQueue<>((o1, o2) -> o1[4]-o2[4]);
        for(int k=0;k<4;k++){
            dist[rowStart][colStart][k]=0;
        }
        priorityQueue.offer(new int[]{-1,-1,rowStart,colStart,0});

        while (priorityQueue.isEmpty()==false){
            int [] a = priorityQueue.poll();
            int preX=a[0],preY=a[1],x=a[2],y=a[3],time=a[4];
            for (int k=0;k<dir.length;k++){
                int[] d=dir[k];
                int nextX=x+d[0],nextY=y+d[1];
                if (nextY>=m || nextY<0 || nextX<0 || nextX>=n){
                    continue;
                }
                if (preX==nextX && preY==nextY){
                    continue;
                }
                int nextTime = time+timePreRoad;
                if (preX!=-1 && preY!=-1 && !isRight(preX,preY,x,y,nextX,nextY)){
                    nextTime+=lights[x][y];
                }
            if (nextTime>=dist[nextX][nextY][k]) {
                continue;
            }

            dist[nextX][nextY][k]=nextTime;
            priorityQueue.offer(new int[]{x,y,nextX,nextY,nextTime});

            }


        }
        int res=Integer.MAX_VALUE;
         for (int k=0;k<4;k++){
             res=res<dist[rowEnd][colEnd][k]?res:dist[rowEnd][colEnd][k];
         }
         return res;

    }

    private boolean isRight(int preX, int preY, int x, int y, int nextX, int nextY) {
        return ((nextX-x)*(y-preY) - (nextY-y)*(x-preX))>0;
    }

}
