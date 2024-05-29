package com.ij34.oj.huawei.two.ac;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * OD402. 亲子游戏
 * https://hydro.ac/d/HWOD2023/p/OD402
 * BFS 二维数组最短路径
 * @Author: ij34
 * @Date: 2024-05-29
 */

public class ParentChildGame {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N =Integer.valueOf(sc.nextLine());
        int[][] a = new int[N][N];
        for (int i=0;i<N;i++){
            a[i]= Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        int[] mom = new int[2],baby = new int[2];
        for (int i=0;i<N;i++){
            for (int j=0;j<N;j++){
                if (a[i][j]==-3){
                    mom[0]=i;
                    mom[1]=j;
                }else if (a[i][j]==-2){
                    baby[0]=i;
                    baby[1]=j;
                }
            }
        }

        bfs(a,mom[0],mom[1],baby[0],baby[1]);

        System.out.println(maxRes);

    }

    private static int minSize = Integer.MAX_VALUE;//最小时间
    private static int maxRes = -1;//最大糖果数

    private static void bfs(int[][] a, int x, int y, int bi, int bj) {
        boolean[][] visited = new boolean[a.length][a[0].length];
        // x y 时间 糖果
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((c, d) -> {
            if (c[2]!=d[2]){
                return c[2]-d[2];
            }
            return d[3]-c[3];
        });
        priorityQueue.add(new int[]{x,y,0,0});
        visited[x][y]=true;
        while (priorityQueue.size()>0){
            int[] poll =priorityQueue.poll();

            int i=poll[0],j=poll[1],size=poll[2],res=poll[3];

            if (i==bi && j==bj){
                if (size<minSize){
                    minSize=size;
                    maxRes=res;
                    continue;
                }
                if (size==minSize && res>maxRes){
                    maxRes=res;
                }
                continue;
            }

            int[][] dir ={{1,0},{-1,0},{0,1},{0,-1}};
            for (int[] d :dir){
                int ci=i+d[0],cj=j+d[1];
                if (ci>=0 && cj>=0 && ci<a.length && cj<a[0].length && visited[ci][cj]==false && a[ci][cj]!=-1){
                    visited[ci][cj]=true;
                    priorityQueue.add(new int[]{ci,cj,size+1,res+(a[ci][cj]>0?a[ci][cj]:0)});
                }
            }
        }

    }
}

